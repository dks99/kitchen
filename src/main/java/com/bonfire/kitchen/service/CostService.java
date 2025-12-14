package com.bonfire.kitchen.service;

import com.bonfire.kitchen.entity.Recipe;
import com.bonfire.kitchen.entity.RecipeIngredient;
import org.springframework.stereotype.Service;

@Service
public class CostService {

    public double calculateRecipeCost(Recipe recipe) {
        double cost = 0;
        for (RecipeIngredient ri : recipe.getIngredients()) {
            cost += ri.getQuantity() * ri.getIngredient().getPricePerUnit();
        }
        return cost;
    }
}
