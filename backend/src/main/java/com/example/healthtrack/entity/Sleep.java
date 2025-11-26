package com.example.healthtrack.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Sleep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDate date;
    private Integer duration;
    private Integer quality;
    private LocalTime bedTime;
    private LocalTime wakeupTime;
    private Integer awakenings;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public LocalTime getBedTime() {
        return bedTime;
    }

    public void setBedTime(LocalTime bedTime) {
        this.bedTime = bedTime;
    }

    public LocalTime getWakeupTime() {
        return wakeupTime;
    }

    public void setWakeupTime(LocalTime wakeupTime) {
        this.wakeupTime = wakeupTime;
    }

    public Integer getAwakenings() {
        return awakenings;
    }

    public void setAwakenings(Integer awakenings) {
        this.awakenings = awakenings;
    }
}
