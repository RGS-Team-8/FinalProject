package com.codingSchool.webApp.Domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table (name="part")
public class Part implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, name = "type")
    private String type;

    @Column(nullable = false, name = "cost")
    private double cost;

    @Column(nullable = false, name = "partid")
    private int partid;

    public Part() {
    }

    public Part(Long id, String type, double cost, int partid) {
        this.id = id;
        this.type = type;
        this.cost = cost;
        this.partid = partid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getPartid() {
        return partid;
    }

    public void setPartid(int partid) {
        this.partid = partid;
    }
}
