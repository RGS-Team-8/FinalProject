package com.codingSchool.webApp.Repository;

import com.codingSchool.webApp.Domain.Repair;
import com.codingSchool.webApp.Domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RepairRepository extends CrudRepository<Repair,Long> {

    List<Repair> findAll();

    List<Repair> findByDatetimeAfterAndDatetimeBefore(LocalDateTime start,LocalDateTime end);

    Repair save(Repair repair);

    Repair delete(long serviceid);

    List<Repair> findByDatetime(LocalDateTime datetime);

    List<Repair> findTop10ByOrderByDatetime();

   List<Repair> findTop10ByStatusOrderByDatetime(String status);

//    List<Repair> findByStatusContaining(String Pending);
}
