package com.codingSchool.webApp.Repository;

import com.codingSchool.webApp.Domain.Repair;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairRepository extends CrudRepository<Repair,Long> {

    List<Repair> findAll();

    Repair save(Repair repair);

    List<Repair> findTop10ByOrderByDatetime();


}
