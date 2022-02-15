package com.example.weather;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String date;
    private String condition;
    private String icon;
    private String temp;
    private String name;

    public Weather() {
    }

    public Weather(int id, String date, String condition, String icon, String temp, String name) {
        this.date = date;
        this.condition = condition;
        this.icon = icon;
        this.temp = temp;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getCondition() {
        return condition;
    }

    public String getIcon() {
        return icon;
    }

    public String getTemp() {
        return temp;
    }

    public String getName() {
        return name;
    }
}
