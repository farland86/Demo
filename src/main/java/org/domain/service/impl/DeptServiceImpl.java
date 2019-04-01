package org.domain.service.impl;

import java.util.List;

/**
 * Created by root on 3/20/19.
 */

import org.domain.dto.DeptDto;
import org.domain.model.Dept;
import org.domain.repository.DeptRepository;
import org.domain.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptRepository deptRepository;

    @Override
    public void save(DeptDto dto){
    	
        if (!deptRepository.findByName(dto.getDeptName()).isEmpty()) {
        	throw new RuntimeException("This dept already exist.");
        }
        
        deptRepository.save(new Dept(dto));
        
    }
    
    @Override
    public void update(DeptDto dto){

        if(deptRepository.findByName(dto.getDeptOldName()).isEmpty()){
            throw new RuntimeException("Can not find this dept.");
        }

        if(!deptRepository.findByName(dto.getDeptName()).isEmpty()){
        	throw new RuntimeException("This dept already exist.");
        }
        
        deptRepository.save(new Dept(dto.getDeptID(), dto.getDeptName()));
        
    }

    @Override
    public void delete(long deptID) {
    	
        if (deptRepository.findById(deptID) == null) {
        	throw new RuntimeException("Can not find this dept.");
        }
        
        deptRepository.deleteById(deptID);
        
    }

	@Override
	public List<Dept> find() {
		return deptRepository.findAll();
	}
}
