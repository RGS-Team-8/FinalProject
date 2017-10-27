package com.codingSchool.webApp.Model;

import com.codingSchool.webApp.Domain.User;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SearchVehicleForm{
        private static final String SSN_PATTERN = "^[0-9]*$";
        private static final int SSN_MINSIZE = 9;
        private static final String MODEL_PATTERN = "^[a-zA-Z0-9]*$";
        private static final String NAME_PATTERN = "^[a-zA-z]*$";
        private static final String YEAR_PATTERN = "^[1-9]{4}$";
        private static final String PLATE_PATTERN = "^[A-Z]{3}\\-[1-9][0-9]{3}$";

        @NotNull(message = "{insert.ssn.null}")
        @Pattern(regexp = SSN_PATTERN, message = "{insert.ssn.invalid}")
        @Size(min = SSN_MINSIZE, message = "{insert.ssn.size}")
        private String ssn;

        @Pattern(regexp = MODEL_PATTERN, message = "{insert.model.invalid}")
        @NotNull
        private String model;

        @NotNull
        @Size(min=2)
        private String brand;

        @NotNull(message = "{insert.year.null}")
        @Pattern(regexp = YEAR_PATTERN, message = "{insert.year.invalid}")
        private String year;

        @NotNull
        @Pattern(regexp = NAME_PATTERN, message = "{insert.name.invalid}")
        private String color;

        @NotNull(message = "{insert.plate.null}")
        @Pattern(regexp = PLATE_PATTERN, message = "{insert.plate.invalid}")
        private String plate;

        @NotNull(message = "{Object user can not be null}")
        private User user;

        @NotNull(message = "{insert.userid.null}")
        @Range(min=1, max=1000,message = "insert.userid.invalid")
        private long userid;

        private long id;

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
