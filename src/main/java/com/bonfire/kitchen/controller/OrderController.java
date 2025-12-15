package com.bonfire.kitchen.controller;

import com.bonfire.kitchen.entity.Order;
import com.bonfire.kitchen.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Map<String, Object> createOrder(@RequestBody Order order) {
        return orderService.createOrderWithProfit(order);
    }

    @GetMapping
    public List<Order> getAll() {
        return orderService.findAll();
    }
}
