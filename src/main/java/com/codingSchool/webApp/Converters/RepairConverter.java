package com.codingSchool.webApp.Converters;

import com.codingSchool.webApp.Domain.Repair;
import com.codingSchool.webApp.Domain.User;
import com.codingSchool.webApp.Model.InsertRepairForm;

public class RepairConverter {
    public static Repair buildRepairObject(InsertRepairForm insertRepairForm) {
        Repair repair = new Repair();
        repair.setCost(insertRepairForm.getCost());
        repair.setDatetime(insertRepairForm.getDatetime());
        repair.setStatus(insertRepairForm.getStatus());
        repair.setType(insertRepairForm.getType());
        repair.setFreetext(insertRepairForm.getFreetext());
        User user = new User();
        user.setUserid(insertRepairForm.getUserid());
        repair.setUser(user);

        return repair;
    }
}
