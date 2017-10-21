package com.codingSchool.webApp.Model;

import com.codingSchool.webApp.Domain.Repair;

import java.util.List;

public class UserForm {
    private List<Repair> repairs;

    public List<Repair> getRepairs() {
        return repairs;
    }

    public void setRepairs(List<Repair> repairs) {
        this.repairs = repairs;
    }
}
