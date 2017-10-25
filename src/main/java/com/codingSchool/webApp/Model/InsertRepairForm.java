package com.codingSchool.webApp.Model;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

public class InsertRepairForm {


    private static final String FREETEXT = "^[a-zA-Z0-9_]+( [a-zA-Z0-9_]+)*$";



//    private static final int USER_ID_MINSIZE = 9;

    @NotNull(message = "{insert.cost.null}")
    @Digits(integer = 10 /*precision*/, fraction = 5/*scale*/)
    private double cost;

    @NotNull(message = "{insert.date.null}")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime datetime;

    @NotNull(message = "{insert.status.null}")
    private String status;

    @NotNull(message = "{insert.type.null}")
    private String type;

    @NotNull(message = "{insert.freetext.null}")
    @Pattern(regexp = FREETEXT, message = "{insert.freetext.invalid}")
    private String freetext;

    @NotNull(message = "{insert.userid.null}")
    @Range(min=1, max=1000,message = "insert.userid.invalid")
    private long userid;


    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFreetext() {
        return freetext;
    }

    public void setFreetext(String freetext) {
        this.freetext = freetext;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }
}
