package com.bonfire.kitchen.controller;

import com.bonfire.kitchen.entity.Order;
import com.bonfire.kitchen.service.OrderService;
import com.bonfire.kitchen.service.ProfitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProfitService profitService;

    @PostMapping
    public Map<String, Object> createOrder(@RequestBody Order order) {

        Order saved = orderService.createOrder(order);

        double profit = profitService.calculateProfit(saved);

        Map<String, Object> response = new HashMap<>();
        response.put("orderId", saved.getId());
        response.put("profit", profit);

        return response;
    }

    @GetMapping
    public List<Order> getAll() {
        return orderService.findAll();
    }
}
