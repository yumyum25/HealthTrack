package com.example.healthtrack.service;

import com.example.healthtrack.entity.Reminder;
import com.example.healthtrack.repository.ReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReminderService {

    @Autowired
    private ReminderRepository reminderRepository;

    public List<Reminder> getAllReminders() {
        return reminderRepository.findAll();
    }

    public Reminder createReminder(Reminder reminder) {
        return reminderRepository.save(reminder);
    }
}
