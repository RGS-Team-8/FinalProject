package com.codingSchool.webApp.Converters;

import com.codingSchool.webApp.Domain.Repair;
import com.codingSchool.webApp.Domain.User;
import com.codingSchool.webApp.Model.SearchRepairForm;

public class RepairUpdater {
    public static Repair updateRepairObject(SearchRepairForm searchRepairForm) {
        Repair repair = new Repair();
        repair.setCost(searchRepairForm.getCost());
        repair.setDatetime(searchRepairForm.getDatetime());
        repair.setStatus(searchRepairForm.getStatus());
        repair.setType(searchRepairForm.getType());
        repair.setFreetext(searchRepairForm.getFreetext());
        repair.setServiceid(searchRepairForm.getServiceid());
        User user = new User();
        user.setUserid(searchRepairForm.getUserid());
        repair.setUser(user);

        return repair;
    }
}
