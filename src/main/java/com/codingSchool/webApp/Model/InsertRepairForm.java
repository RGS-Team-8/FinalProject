package com.codingSchool.webApp.Model;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class InsertRepairForm {


   // private static final String COST_PATTERN = "[0-9]{1,13}(\\.[0-9]*)?";
    private static final String USERID_PATTERN = "^[0-9]*$";

    //@Pattern(regexp = COST_PATTERN, message = "{insert.cost.invalid}")
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

    @Size(min=2)
    @NotNull(message = "{insert.freetext.null}")
    private String freetext;

    //@Pattern(regexp = USERID_PATTERN, message = "{insert.userid.invalid}")
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
