package com.codingSchool.webApp.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.codingSchool.webApp.Domain.Vehicle;

import java.util.List;


@Repository
public interface VehicleRepository extends CrudRepository<Vehicle,Long> {

    Vehicle save(Vehicle vehicle);

   Vehicle delete(long id);

    List<Vehicle> findByPlate(String plate);

   // List<Vehicle> findBy//


}
//    List<Repair> findAll();
//
//    List<Repair> findByDatetimeAfterAndDatetimeBefore(LocalDateTime start,LocalDateTime end);
//
//    Repair save(Repair repair);
//
//    Repair delete(long serviceid);
//
//    List<Repair> findByDatetime(LocalDateTime datetime);
//
//    List<Repair> findTop10ByOrderByDatetime();
//
//    List<Repair> findTop10ByStatusOrderByDatetime(String status);


