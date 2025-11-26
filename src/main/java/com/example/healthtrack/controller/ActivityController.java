package com.example.healthtrack.controller;

import com.example.healthtrack.entity.Activity;
import com.example.healthtrack.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping
    public ResponseEntity<List<Activity>> getAllActivities() {
        return ResponseEntity.ok(activityService.getAllActivities());
    }

    @PostMapping
    public ResponseEntity<Activity> createActivity(@RequestBody Activity activity) {
        return ResponseEntity.ok(activityService.createActivity(activity));
    }
}
