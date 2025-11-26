package com.example.healthtrack.service;

import com.example.healthtrack.entity.Nutrition;
import com.example.healthtrack.repository.NutritionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NutritionService {

    @Autowired
    private NutritionRepository nutritionRepository;

    public List<Nutrition> getAllNutrition() {
        return nutritionRepository.findAll();
    }

    public Nutrition createNutrition(Nutrition nutrition) {
        return nutritionRepository.save(nutrition);
    }
}
