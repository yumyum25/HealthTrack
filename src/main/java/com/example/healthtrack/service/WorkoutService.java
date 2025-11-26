package com.example.healthtrack.service;

import com.example.healthtrack.entity.Workout;
import com.example.healthtrack.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    public Workout createWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }
}
