package com.bonfire.kitchen.service;

import org.springframework.stereotype.Service;

@Service
public class CommissionService {

    public double getCommissionRate(String platform) {
        return switch (platform.toUpperCase()) {
            case "ZOMATO" -> 0.25;
            case "SWIGGY" -> 0.23;
            default -> 0.0;
        };
    }

    public double calculateCommission(double sellingPrice, String platform) {
        return sellingPrice * getCommissionRate(platform);
    }
}
