package com.example.takeAhike.models.Forms;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by LaunchCode
 */
@Entity
public class Hike {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @NotNull
    @Size(min=1, message = "Description must not be empty")
    private String description;

    @NotNull (message ="Please enter an approximate length")
    private double length;

    @NotNull (message = "Please provide a location for this hike")
    private String location;

    @ManyToOne
    private Category category;

    public Hike(String name, String description, double length, String location) {
        this.name = name;
        this.description = description;
        this.length = length;
        this.location = location;
    }

    public Hike() { }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory (Category category) {
        this.category = category;
    }
}

// Getters and setters set, new values added to Cheese to reflect Hike //