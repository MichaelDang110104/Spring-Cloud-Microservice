package com.example.order.controllers;

import com.example.order.dto.OrderDTO;
import com.example.order.pojos.Order;
import com.example.order.response.ResponseHandler;
import com.example.order.services.IOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final IOrderService iOrderService;
    private final ModelMapper modelMapper;
    @Autowired
    public OrderController(IOrderService iOrderService,ModelMapper modelMapper) {
        this.iOrderService = iOrderService;
        this.modelMapper = new ModelMapper();
    }
    @GetMapping("/get-order-by-id")
    public ResponseEntity<Object> getOrderById(int id) {
        return ResponseHandler.responseBuilder("Get order by id successfully !", HttpStatus.OK, iOrderService.getOrderById(id));
    }
    @GetMapping("/get-all-order")
    public ResponseEntity<Object> getAllOrder() {
        List<OrderDTO> returnList = iOrderService.getAllOrders();
        return ResponseHandler.responseBuilder("Get all orders successfully !", HttpStatus.OK,returnList);
    }
    @DeleteMapping("/delete-order")
    public ResponseEntity<Object> deleteOrder(int id) {
        OrderDTO orderDTO = iOrderService.getOrderById(id);
        iOrderService.deleteOrder(id);
        return ResponseHandler.responseBuilder("Delete order by id successfully !", HttpStatus.OK,orderDTO);
    }
    @PostMapping("/create-order")
    public ResponseEntity<Object> createOrder(@RequestBody OrderDTO orderDTO) {
        iOrderService.saveOrder(orderDTO);
        return ResponseHandler.responseBuilder("Create order successfully !", HttpStatus.CREATED,orderDTO);
    }
    @PutMapping("/update-order")
    public ResponseEntity<Object> updateOrder(@RequestBody OrderDTO orderDTO,@RequestParam int id) {
        iOrderService.updateOrder(orderDTO,id);
        return ResponseHandler.responseBuilder("Update order successfully !", HttpStatus.OK,orderDTO);
    }
}
