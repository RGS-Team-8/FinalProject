package com.codingSchool.webApp.Model;

import javax.validation.constraints.NotNull;

public class InsertVehicleForm {

    @NotNull(message = "{insert.model.null}")
    private String model;
    @NotNull(message = "{insert.brand.null}")
    private String brand;
    @NotNull(message = "{insert.year.null}")
    private String year;
    @NotNull(message = "{insert.color.null}")
    private String color;
    @NotNull(message = "{insert.plate.null}")
    private String plate;
    @NotNull(message = "{insert.userid.null}")
    private long userid;



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

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }


}
