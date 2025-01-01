package com.example.order.services;

import com.example.order.dto.OrderLineDTO;
import com.example.order.pojos.OrderLine;

import java.util.List;

public interface IOrderLineService {
    public List<OrderLineDTO> getAllOrderLines();
    public OrderLineDTO getOrderLineById(int id);
    public int addOrderLine(OrderLineDTO orderLineDTO);
    public List<OrderLineDTO> findAllByOrderId(Integer orderId);
}
