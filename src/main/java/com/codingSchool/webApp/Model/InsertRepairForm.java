package com.codingSchool.webApp.Model;

import com.codingSchool.webApp.Domain.User;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

public class InsertRepairForm {

//    private static final String COST_PATTERN = "^[0-9]*$";

    private Long serviceid;

    @NotNull(message = "{insert.cost.null}")
//    @Pattern(regexp = COST_PATTERN, message = "{insert.cost.invalid}")
    private double cost;

    @NotNull(message = "{insert.date.null}")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime datetime;

    @NotNull(message = "{insert.status.null}")
    private String status;

    @NotNull(message = "{insert.type.null}")
    private String type;

    private String freetext;

    @NotNull(message = "{insert.userid.null}")
    private long userid;

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
}
