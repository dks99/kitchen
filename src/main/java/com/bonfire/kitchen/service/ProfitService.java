package com.bonfire.kitchen.service;

import com.bonfire.kitchen.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfitService {

    @Autowired
    private CostService costService;

    @Autowired
    private CommissionService commissionService;

    public double calculateProfit(Order order) {

        double foodCost =
                costService.calculateRecipeCost(order.getRecipe());

        double commission =
                commissionService.calculateCommission(
                        order.getSellingPrice(),
                        order.getPlatform()
                );

        return order.getSellingPrice()
                - foodCost
                - commission
                - order.getPackagingCost();
    }
}
