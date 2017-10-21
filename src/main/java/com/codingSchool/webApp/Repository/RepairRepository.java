package com.codingSchool.webApp.Repository;

import com.codingSchool.webApp.Domain.Repair;
import com.codingSchool.webApp.Domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//Jpa repository gia perisoteres sinartiseis

@Repository
public interface RepairRepository extends CrudRepository<Repair,Long> {

    // @Query("SELECT*FROM)
    //List<Repair> findByUser_Userid(int userid);
    //List<Repair> findByUser_Userid(int userid);
    List<Repair> findAll();

    Repair save(Repair repair);

    List<Repair> findTop10ByOrderByDatetime();


}
