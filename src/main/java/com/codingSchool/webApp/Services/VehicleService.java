package com.codingSchool.webApp.Services;

import com.codingSchool.webApp.Domain.Vehicle;

import java.util.List;

public interface VehicleService {

    void save(Vehicle vehicle);

    void insert(Vehicle vehicle);


     void update(Vehicle repair);


     void delete(long id);

    List<Vehicle> findByPlate(String plate);

}
