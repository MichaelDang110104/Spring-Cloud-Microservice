package com.example.order.services;

import com.example.order.customer.CustomerClient;
import com.example.order.dto.OrderDTO;
import com.example.order.dto.OrderLineDTO;
import com.example.order.kafka.OrderConfirmation;
import com.example.order.kafka.OrderProducer;
import com.example.order.pojos.Order;
import com.example.order.product.ProductClient;
import com.example.order.product.PurchaseRequest;
import com.example.order.repositories.IOrderRepo;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService {
    private final IOrderRepo iOrderRepo;
    private final ModelMapper modelMapper;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final IOrderLineService iOrderLineService;
    private final OrderProducer orderProducer;
    @Autowired
    public OrderService(IOrderRepo iOrderRepo,ModelMapper modelMapper,CustomerClient customerClient,ProductClient productClient
            ,IOrderLineService iOrderLineService,OrderProducer orderProducer) {
        this.iOrderRepo = iOrderRepo;
        this.modelMapper = modelMapper;
        this.customerClient = customerClient;
        this.productClient = productClient;
        this.iOrderLineService = iOrderLineService;
        this.orderProducer = orderProducer;
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        List<Order> list =  iOrderRepo.findAll();
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (Order order : list) {
            orderDTOList.add(modelMapper.map(order, OrderDTO.class));
        }
        return orderDTOList;
    }

    @Override
    public OrderDTO getOrderById(int id) {
        Order order = iOrderRepo.findById(id).orElseThrow(()-> new RuntimeException("Order not found"));
        return modelMapper.map(order, OrderDTO.class);
    }
    @Transactional
    @Override
    public OrderDTO saveOrder(OrderDTO orderDTO) {
        var customer = this.customerClient.getCustomer(orderDTO.getCustomerID()).orElseThrow(()-> new EntityNotFoundException("Customer not found"));
        var purchaseProduct = this.productClient.purchaseProducts(orderDTO.getProducts());
        Order order = modelMapper.map(orderDTO, Order.class);
        iOrderRepo.save(order);
        for (PurchaseRequest purchaseRequest : orderDTO.getProducts()) {
            iOrderLineService.addOrderLine(
                    new OrderLineDTO(
                            order.getId(),
                            purchaseRequest.getProductId(),
                            purchaseRequest.getQuantity()
                    )
            );
        }
        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(orderDTO.getReference(),
                        order.getTotalAmount(),
                        orderDTO.getPaymentMethod(),
                        customer,
                        purchaseProduct)
        );
        return orderDTO;
    }

    @Override
    public OrderDTO deleteOrder(int id) {
        Order order = iOrderRepo.findById(id).get();
        iOrderRepo.delete(order);
        return modelMapper.map(order, OrderDTO.class);
    }

    @Override
    public OrderDTO updateOrder(OrderDTO orderDTO, int id) {
        iOrderRepo.save(modelMapper.map(orderDTO, Order.class));
        return orderDTO;
    }
}
