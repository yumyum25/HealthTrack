package com.example.healthtrack.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Nutrition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDate date;
    private Integer caloriesConsumed;
    private Double carbohydratesPercentage;
    private Double proteinsPercentage;
    private Double fatsPercentage;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nutrition")
    private List<Meal> meals;

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

    public Integer getCaloriesConsumed() {
        return caloriesConsumed;
    }

    public void setCaloriesConsumed(Integer caloriesConsumed) {
        this.caloriesConsumed = caloriesConsumed;
    }

    public Double getCarbohydratesPercentage() {
        return carbohydratesPercentage;
    }

    public void setCarbohydratesPercentage(Double carbohydratesPercentage) {
        this.carbohydratesPercentage = carbohydratesPercentage;
    }

    public Double getProteinsPercentage() {
        return proteinsPercentage;
    }

    public void setProteinsPercentage(Double proteinsPercentage) {
        this.proteinsPercentage = proteinsPercentage;
    }

    public Double getFatsPercentage() {
        return fatsPercentage;
    }

    public void setFatsPercentage(Double fatsPercentage) {
        this.fatsPercentage = fatsPercentage;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }
}
