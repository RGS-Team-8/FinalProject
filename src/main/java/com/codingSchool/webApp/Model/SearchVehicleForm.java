package com.codingSchool.webApp.Model;

import com.codingSchool.webApp.Domain.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SearchVehicleForm{
        private static final String SSN_PATTERN = "^[0-9]*$";
        private static final int SSN_MINSIZE = 9;

        @NotNull(message = "{insert.ssn.null}")
        @Pattern(regexp = SSN_PATTERN, message = "{insert.ssn.invalid}")
        @Size(min = SSN_MINSIZE, message = "{insert.ssn.size}")
        private String ssn;
        private Long id;

        private String model;

        private String brand;

        private String year;

        private String color;

        @NotNull(message="{insert.plate.null}")
        private String plate;

        private User user;

        private long userid;


    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }


}
