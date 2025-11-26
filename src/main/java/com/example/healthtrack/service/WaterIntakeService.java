package com.example.healthtrack.service;

import com.example.healthtrack.entity.WaterIntake;
import com.example.healthtrack.repository.WaterIntakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaterIntakeService {

    @Autowired
    private WaterIntakeRepository waterIntakeRepository;

    public List<WaterIntake> getAllWaterIntake() {
        return waterIntakeRepository.findAll();
    }

    public WaterIntake createWaterIntake(WaterIntake waterIntake) {
        return waterIntakeRepository.save(waterIntake);
    }
}
