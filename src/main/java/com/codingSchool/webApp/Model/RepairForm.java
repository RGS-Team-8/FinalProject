package com.codingSchool.webApp.Model;

import java.util.Date;

public class RepairForm {
    private double cost;
    private Date datetime;


    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }


}
