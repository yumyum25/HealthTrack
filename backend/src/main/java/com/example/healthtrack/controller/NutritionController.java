package com.example.healthtrack.controller;

import com.example.healthtrack.entity.Nutrition;
import com.example.healthtrack.service.NutritionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/nutrition")
public class NutritionController {

    @Autowired
    private NutritionService nutritionService;

    @GetMapping
    public ResponseEntity<List<Nutrition>> getAllNutrition() {
        return ResponseEntity.ok(nutritionService.getAllNutrition());
    }

    @PostMapping
    public ResponseEntity<Nutrition> createNutrition(@RequestBody Nutrition nutrition) {
        return ResponseEntity.ok(nutritionService.createNutrition(nutrition));
    }
}
