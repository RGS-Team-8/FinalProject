package com.codingSchool.webApp.Domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table (name="vehicle")
public class Vehicle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, name = "userid", unique = true)
    private int userid;

    @Column(nullable = false, name = "model")
    private String model;

    @Column(nullable = false, name = "brand")
    private String brand;

    @Column(nullable = false, name = "year")
    private int year;

    @Column(nullable = false, name = "color")
    private String color;

    @Column(nullable = false, name = "plate", unique = true)
    private String plate;

    public Vehicle() {
    }

    public Vehicle(Long id, int userid, String model, String brand, int year, String color, String plate) {
        this.id = id;
        this.userid = userid;
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

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
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
