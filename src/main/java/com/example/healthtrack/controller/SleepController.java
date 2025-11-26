package com.example.healthtrack.controller;

import com.example.healthtrack.entity.Sleep;
import com.example.healthtrack.service.SleepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sleep")
public class SleepController {

    @Autowired
    private SleepService sleepService;

    @GetMapping
    public ResponseEntity<List<Sleep>> getAllSleep() {
        return ResponseEntity.ok(sleepService.getAllSleep());
    }

    @PostMapping
    public ResponseEntity<Sleep> createSleep(@RequestBody Sleep sleep) {
        return ResponseEntity.ok(sleepService.createSleep(sleep));
    }
}
