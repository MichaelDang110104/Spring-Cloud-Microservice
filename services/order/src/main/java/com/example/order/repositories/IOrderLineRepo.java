package com.example.order.repositories;

import com.example.order.pojos.Order;
import com.example.order.pojos.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOrderLineRepo extends JpaRepository<OrderLine,Integer> {
    Iterable<Integer> order(Order order);
    List<OrderLine> findAllByOrderId(Integer orderId);
}
