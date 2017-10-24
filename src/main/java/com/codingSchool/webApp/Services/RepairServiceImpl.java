package com.codingSchool.webApp.Services;

import com.codingSchool.webApp.Domain.Repair;
import com.codingSchool.webApp.Repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RepairServiceImpl implements RepairService {

    @Autowired
    private  RepairRepository repairRepository;

    public RepairServiceImpl(RepairRepository repairRepository){
        this.repairRepository=repairRepository;
    }

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

    public List<Repair> findTop10ByOrderByDatetime(){
        List<Repair> r2=new ArrayList<>();
        for(Repair repair:repairRepository.findTop10ByOrderByDatetime())
            r2.add(repair);

        return r2;
    }

    @Override
    public void insert(Repair repair) {
        repairRepository.save(repair);
    }

    @Override
    public void update(Repair repair) { repairRepository.save(repair); }

    @Override
    public void delete(long serviceid) { repairRepository.delete(serviceid); }
}
