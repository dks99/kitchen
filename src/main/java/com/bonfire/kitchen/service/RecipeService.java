package com.bonfire.kitchen.service;

import com.bonfire.kitchen.entity.Recipe;
import com.bonfire.kitchen.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepo;

    public Recipe createRecipe(Recipe recipe) {
        return recipeRepo.save(recipe);
    }

    public List<Recipe> findAll() {
        return recipeRepo.findAll();
    }
}
