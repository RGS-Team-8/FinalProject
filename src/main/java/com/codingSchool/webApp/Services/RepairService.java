package com.codingSchool.webApp.Services;

import com.codingSchool.webApp.Domain.Repair;
import java.util.List;

public interface RepairService{

    List<Repair> findAll();

    void save(Repair repair);

    List<Repair> findTop10ByOrderByDatetime();
}
