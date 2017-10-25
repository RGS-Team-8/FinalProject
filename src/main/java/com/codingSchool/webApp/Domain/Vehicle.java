package com.codingSchool.webApp.Domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table (name="vehicle")
public class Vehicle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, name = "model")
    private String model;

    @Column(nullable = false, name = "brand")
    private String brand;

    @Column(nullable = false, name = "year")
    private String year;

    @Column(nullable = false, name = "color")
    private String color;

    @Column(nullable = false, name = "plate", unique = true)
    private String plate;

    @ManyToOne(optional = false)
    @JoinColumn(name="userid", referencedColumnName = "userid")
    private User user;

    public Vehicle() {
    }

    public Vehicle(Long id, User user, String model, String brand, String year, String color, String plate) {
        this.id = id;
        this.user = user;
        this.model = model;
        this.brand = brand;
        this.year = year;
        this.color = color;
        this.plate = plate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   public User getUser(){return user;
    }

    public void setUser(User user){this.user=user;}

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
}
