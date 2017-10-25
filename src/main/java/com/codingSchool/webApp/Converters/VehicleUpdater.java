package com.codingSchool.webApp.Converters;

import com.codingSchool.webApp.Domain.User;
import com.codingSchool.webApp.Domain.Vehicle;
import com.codingSchool.webApp.Model.SearchVehicleForm;

public class VehicleUpdater {
    public static Vehicle updateVehicleObject(SearchVehicleForm searchVehicleForm) {
        Vehicle  vehicle= new Vehicle();
        vehicle.setModel(searchVehicleForm.getModel());
        vehicle.setBrand(searchVehicleForm.getBrand());
        vehicle.setYear(searchVehicleForm.getYear());
        vehicle.setColor(searchVehicleForm.getColor());
        vehicle.setPlate(searchVehicleForm.getPlate());
        vehicle.setId(searchVehicleForm.getId());
        User user = new User();
        user.setUserid(searchVehicleForm.getUserid());
        vehicle.setUser(user);

        return vehicle;
    }

}
