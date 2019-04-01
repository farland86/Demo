package org.domain.controller;

import org.domain.dto.EmpDto;
import org.domain.model.Emp;
import org.domain.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

/**
 * Created by root on 3/20/19.
 */

@RestController
@RequestMapping(value = "emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    @PostMapping
    public void add(@Valid @RequestBody EmpDto dto){
        empService.save(dto);
    }

    @PutMapping
    public void update(@RequestBody EmpDto dto){
        if (!dto.updateValidate(dto)) {
        	throw new RuntimeException("Invalid parameter");
        }
        empService.update(dto);
    }

    @DeleteMapping("{empID}")
    public void remove(@PathVariable("empID") Long empID){
        empService.delete(empID);
    }

    @GetMapping
    public List<Emp> find(@RequestBody EmpDto dto){
        if (!dto.findValidate(dto)) {
        	throw new RuntimeException("Invalid parameter");
        }
        return empService.findEmp(dto);
    }

}
