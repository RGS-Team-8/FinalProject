package com.codingSchool.webApp.Model;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class InsertVehicleForm {

    private static final String MODEL_PATTERN = "^[a-zA-Z0-9]*$";
    private static final String NAME_PATTERN = "^[a-zA-z]*$";
    private static final String YEAR_PATTERN = "^[1-9]{4}$";
    private static final String PLATE_PATTERN = "^[A-Z]{3}\\-[1-9][0-9]{3}$";

    @Size(min=2)
    @Pattern(regexp = MODEL_PATTERN, message = "{insert.model.invalid}")
    private String model;

    @Size(min=2)
    @Pattern(regexp = NAME_PATTERN, message = "{insert.name.invalid}")
    private String brand;

    @NotNull(message = "{insert.year.null}")
    @Pattern(regexp = YEAR_PATTERN, message = "{insert.year.invalid}")
    private String year;

    @Size(min=2)
    @Pattern(regexp = NAME_PATTERN, message = "{insert.name.invalid}")
    private String color;

    @NotNull(message = "{insert.plate.null}")
    @Pattern(regexp = PLATE_PATTERN, message = "{insert.plate.invalid}")
    private String plate;

    @NotNull(message = "{insert.userid.null}")
    @Range(min=1, max=1000,message = "insert.userid.invalid")
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
