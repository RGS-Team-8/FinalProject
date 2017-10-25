package com.codingSchool.webApp.Model;

import com.codingSchool.webApp.Domain.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class SearchRepairForm2 {

    private static final String SSN_PATTERN = "^[0-9]*$";
    private static final int SSN_MINSIZE = 9;

    @NotNull(message = "{insert.ssn.null}")
    @Pattern(regexp = SSN_PATTERN, message = "{insert.ssn.invalid}")
    @Size(min = SSN_MINSIZE, message = "{insert.ssn.size}")
    private String ssn;

    private Long serviceid;

    private double cost;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime datetime;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime datetime2;

    private String status;

    private String type;

    private String freetext;

    private User user;

    private long userid;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Long getServiceid() {
        return serviceid;
    }

    public void setServiceid(Long serviceid) {
        this.serviceid = serviceid;
    }

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

    public LocalDateTime getDatetime2() {
        return datetime2;
    }

    public void setDatetime2(LocalDateTime datetime2) {
        this.datetime2 = datetime2;
    }
}
