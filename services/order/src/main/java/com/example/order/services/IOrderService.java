package com.example.order.services;

import com.example.order.dto.OrderDTO;
import com.example.order.pojos.Order;

import java.util.List;

public interface IOrderService {
    public List<OrderDTO> getAllOrders();
    public OrderDTO getOrderById(int id);
    public OrderDTO saveOrder(OrderDTO order);
    public OrderDTO deleteOrder(int id);
    public OrderDTO updateOrder(OrderDTO order, int id);
}
