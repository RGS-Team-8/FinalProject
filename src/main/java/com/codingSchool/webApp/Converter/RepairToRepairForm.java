package com.codingSchool.webApp.Converter;

import com.codingSchool.webApp.Domain.Repair;
import com.codingSchool.webApp.Model.RepairForm;

public class RepairToRepairForm {

    public static RepairForm convert(Repair repair) {
        RepairForm repairForm = new RepairForm();
        repairForm.setCost(repair.getCost());
        repairForm.setDatetime(repair.getDatetime());
        return repairForm;
    }
}
