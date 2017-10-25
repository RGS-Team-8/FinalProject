package com.codingSchool.webApp.Services;

import com.codingSchool.webApp.Domain.Repair;
import com.codingSchool.webApp.Domain.User;
import java.time.LocalDateTime;
import java.util.List;

public interface RepairService{

    List<Repair> findAll();

    void save(Repair repair);

    List<Repair> findTop10ByOrderByDatetime();

    //List<Repair> findTop10ByOrderByDatetime();

    List<Repair> findByDatetime(LocalDateTime datetime);
  //  List<Repair> findByDatetimeBetween(LocalDateTime StartDate,LocalDateTime EndDate);


    void insert(Repair repair);

    void update(Repair repair);

    void delete(long serviceid);

    List<Repair> findTop10ByStatusOrderByDatetime(String status);

    List<Repair> findByDatetimeAfterAndDatetimeBefore(LocalDateTime start,LocalDateTime end);

}
