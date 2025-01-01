package com.example.order.controllers;

import com.example.order.dto.OrderLineDTO;
import com.example.order.response.ResponseHandler;
import com.example.order.services.IOrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order-lines")
public class OrderLineController {
    private final IOrderLineService iOrderLineService;

    @Autowired
    public OrderLineController(IOrderLineService iOrderLineService) {
        this.iOrderLineService = iOrderLineService;
    }
    @GetMapping("/order/{orderId}")
    public ResponseEntity<Object> getOrderLine(@PathVariable("orderId") int orderId) {
        return ResponseHandler.responseBuilder("Get All OrderLine by ID", HttpStatus.OK,iOrderLineService.findAllByOrderId(orderId));
    }
}
