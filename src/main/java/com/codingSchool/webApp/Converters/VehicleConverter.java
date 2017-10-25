package com.codingSchool.webApp.Converters;

import com.codingSchool.webApp.Domain.User;
import com.codingSchool.webApp.Domain.Vehicle;
import com.codingSchool.webApp.Model.InsertVehicleForm;

public class VehicleConverter {
    public static Vehicle buildVehicleObject(InsertVehicleForm insertVehicleForm) {
        Vehicle vehicle = new Vehicle();
        vehicle.setModel(insertVehicleForm.getModel());
        vehicle.setBrand(insertVehicleForm.getBrand());
        vehicle.setYear(insertVehicleForm.getYear());
        vehicle.setColor(insertVehicleForm.getColor());
        vehicle.setPlate(insertVehicleForm.getPlate());
        User user = new User();
        user.setUserid(insertVehicleForm.getUserid());
        vehicle.setUser(user);

        return vehicle;
    }
}
