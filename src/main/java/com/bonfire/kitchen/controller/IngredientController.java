package com.bonfire.kitchen.controller;

import com.bonfire.kitchen.entity.Ingredient;
import com.bonfire.kitchen.repository.IngredientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    private final IngredientRepository repo;

    public IngredientController(IngredientRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Ingredient create(@RequestBody Ingredient ingredient) {
        return repo.save(ingredient);
    }

    @GetMapping
    public List<Ingredient> getAll() {
        return repo.findAll();
    }
}
