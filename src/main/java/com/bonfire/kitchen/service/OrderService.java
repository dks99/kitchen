package com.bonfire.kitchen.service;

import com.bonfire.kitchen.entity.Order;
import com.bonfire.kitchen.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private ProfitService profitService;

    public Map<String, Object> createOrderWithProfit(Order order) {
        Order createdOrder = createOrder(order);

        double profit = profitService.calculateProfit(createdOrder);

        Map<String, Object> response = new HashMap<>();
        response.put("orderId", createdOrder.getId());
        response.put("profit", profit);
        return response;
    }

    public Order createOrder(Order order) {
        order.setOrderTime(LocalDateTime.now());
        return orderRepo.save(order);
    }

    public List<Order> findAll() {
        return orderRepo.findAll();
    }
}
