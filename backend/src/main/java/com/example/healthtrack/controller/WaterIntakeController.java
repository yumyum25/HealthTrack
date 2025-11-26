package com.example.healthtrack.controller;

import com.example.healthtrack.entity.WaterIntake;
import com.example.healthtrack.service.WaterIntakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/water-intake")
public class WaterIntakeController {

    @Autowired
    private WaterIntakeService waterIntakeService;

    @GetMapping
    public ResponseEntity<List<WaterIntake>> getAllWaterIntake() {
        return ResponseEntity.ok(waterIntakeService.getAllWaterIntake());
    }

    @PostMapping
    public ResponseEntity<WaterIntake> createWaterIntake(@RequestBody WaterIntake waterIntake) {
        return ResponseEntity.ok(waterIntakeService.createWaterIntake(waterIntake));
    }
}
