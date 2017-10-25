package com.codingSchool.webApp.Services;

import com.codingSchool.webApp.Domain.Repair;
import com.codingSchool.webApp.Domain.User;
import com.codingSchool.webApp.Repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Transactional
public class RepairServiceImpl implements RepairService {

    @Autowired
    private  RepairRepository repairRepository;


    public List<Repair> findAll(){
        List<Repair> r1= new ArrayList<>();
        for (Repair repair:repairRepository.findAll()){
            r1.add(repair);
        }

        return r1;
    }

    public void save(Repair repair){
        repairRepository.save(repair);
    }

    @Override
    public List<Repair>  findTop10ByOrderByDatetime(){
        List<Repair> r2=new ArrayList<>();
        for(Repair repair:repairRepository.findTop10ByOrderByDatetime())
            r2.add(repair);

        return r2;
    }

    public List<Repair> findByDatetimeAfterAndDatetimeBefore(LocalDateTime start,LocalDateTime end){
        List<Repair> r2=new ArrayList<>();
        for(Repair repair:repairRepository.findByDatetimeAfterAndDatetimeBefore(start,end))
            r2.add(repair);

        return r2;
    }




    @Override
    public  List<Repair> findTop10ByStatusOrderByDatetime(String status){
    List<Repair> r3=new ArrayList<>();
        for(Repair repair:repairRepository.findTop10ByStatusOrderByDatetime(status))

    {
        r3.add(repair);
    }
        return r3;
    }

    @Override
    public void insert(Repair repair) {
        repairRepository.save(repair);
    }


    @Override
    public void update(Repair repair) { repairRepository.save(repair); }

    @Override
    public void delete(long serviceid) { repairRepository.delete(serviceid); }

    @Override
    public List<Repair> findByDatetime(LocalDateTime datetime){
        List<Repair> r2=new ArrayList<>();
        for(Repair repair:repairRepository.findByDatetime(datetime))
            r2.add(repair);

        return r2;
    }

}
