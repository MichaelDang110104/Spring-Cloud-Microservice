package com.example.order.services;

import com.example.order.dto.OrderLineDTO;
import com.example.order.pojos.OrderLine;
import com.example.order.repositories.IOrderLineRepo;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Service
public class OrderLineService implements IOrderLineService {
    private final IOrderLineRepo orderLineRepo;
    private final ModelMapper modelMapper;
    @Autowired
    public OrderLineService(IOrderLineRepo orderLineRepo,ModelMapper modelMapper) {
        this.orderLineRepo = orderLineRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OrderLineDTO> getAllOrderLines() {
        List<OrderLine> orderLines = orderLineRepo.findAll();
        List<OrderLineDTO> orderLineDTOs = new ArrayList<>();
        for (OrderLine orderLine : orderLines) {
            orderLineDTOs.add(modelMapper.map(orderLine, OrderLineDTO.class));
        }
        return orderLineDTOs;
    }

    @Override
    public OrderLineDTO getOrderLineById(int id) {
        OrderLineDTO orderLineDTO = modelMapper.map(orderLineRepo.findById(id).get(),OrderLineDTO.class);
        return orderLineDTO;
    }

    @Override
    public int addOrderLine(OrderLineDTO orderLineDTO) {
        var orderLine = modelMapper.map(orderLineDTO, OrderLine.class);
        return orderLineRepo.save(orderLine).getId();
    }

    @Override
    public List<OrderLineDTO> findAllByOrderId(Integer orderId) {
        List<OrderLineDTO> orderLineDTOs = new ArrayList<>();
        List<OrderLine> orderLines = orderLineRepo.findAllByOrderId(orderId);
        for (OrderLine orderLine : orderLines) {
            orderLineDTOs.add(modelMapper.map(orderLine, OrderLineDTO.class));
        }
        return orderLineDTOs;
    }
}
