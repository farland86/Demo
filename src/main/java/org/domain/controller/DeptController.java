package org.domain.controller;

import java.util.List;

import javax.validation.Valid;

import org.domain.dto.DeptDto;
import org.domain.model.Dept;
import org.domain.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by root on 3/20/19.
 */

@Controller
@RequestMapping(value = "depts")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping
    @ResponseBody
    public List<Dept> find(){
    	return deptService.find();
    }
    
    @PostMapping
    @ResponseBody
    public void add(@RequestBody DeptDto dto){
        if(!dto.addValidate(dto)){
        	throw new RuntimeException("Invalid parameter");
        }
        deptService.save(dto);
    }

    @PutMapping
    @ResponseBody
    public void update(@Valid @RequestBody DeptDto dto){
        deptService.update(dto);
    }

    @DeleteMapping("{deptID}")
    @ResponseBody
    public void remove(@PathVariable("deptID") Long deptID){
        deptService.delete(deptID);
    }

}
