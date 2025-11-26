package com.example.healthtrack.service;

import com.example.healthtrack.entity.Sleep;
import com.example.healthtrack.repository.SleepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SleepService {

    @Autowired
    private SleepRepository sleepRepository;

    public List<Sleep> getAllSleep() {
        return sleepRepository.findAll();
    }

    public Sleep createSleep(Sleep sleep) {
        return sleepRepository.save(sleep);
    }
}
