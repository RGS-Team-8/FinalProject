package com.codingSchool.webApp.Services;

import com.codingSchool.webApp.Domain.Repair;
import com.codingSchool.webApp.Domain.User;

import java.time.LocalDateTime;
import java.util.List;

public interface RepairService{

    List<Repair> findAll();

    void save(Repair repair);

    List<Repair> findTop10ByOrderByDatetime();

    List<Repair> findByDatetime(LocalDateTime datetime);

    void insert(Repair repair);

    void update(Repair repair);
}
