package com.codingSchool.webApp.Services;

import com.codingSchool.webApp.Domain.Repair;
import com.codingSchool.webApp.Domain.Vehicle;
import com.codingSchool.webApp.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public void save(Vehicle vehicle){
        vehicleRepository.save(vehicle);
    }

    @Override
    public void insert(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    @Override
    public void update(Vehicle vehicle) { vehicleRepository.save(vehicle); }

    @Override
    public void delete(long id) { vehicleRepository.delete(id); }

    @Override
    public List<Vehicle> findByPlate(String plate){
        List<Vehicle> r2=new ArrayList<>();
        for(Vehicle vehicle:vehicleRepository.findByPlate(plate))
            r2.add(vehicle);

        return r2;

    }

}
