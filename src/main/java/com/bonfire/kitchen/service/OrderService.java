package com.bonfire.kitchen.service;

import com.bonfire.kitchen.entity.Order;
import com.bonfire.kitchen.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepo;

    public Order createOrder(Order order) {
        order.setOrderTime(LocalDateTime.now());
        return orderRepo.save(order);
    }
}
