package com.codingSchool.webApp.Repository;

import com.codingSchool.webApp.Domain.Repair;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RepairRepository extends CrudRepository<Repair,Long> {

    List<Repair> findAll();

    Repair save(Repair repair);

    Repair delete(long serviceid);

    List<Repair> findByDatetime(LocalDateTime datetime);

    List<Repair> findTop10ByOrderByDatetime();

    List<Repair> findByDatetimeBetween(LocalDateTime datetime, LocalDateTime datetime2);

    List<Repair> findTop10ByStatusOrderByDatetime(String status);
}
