package com.workintech.zoo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Koala {
    private Long id;
    private String name;
    private double weight;
    private int sleepHour;
    private String gender;

    public Koala(Long id, String name, double weight, int sleepHour, String gender) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.sleepHour = sleepHour;
        this.gender = gender;
    }

    public Koala() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getSleepHour() {
        return sleepHour;
    }

    public void setSleepHour(int sleepHour) {
        this.sleepHour = sleepHour;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
