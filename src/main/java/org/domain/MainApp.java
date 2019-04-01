package org.domain;

import org.domain.dto.DeptDto;
import org.domain.dto.EmpDto;
import org.domain.service.DeptService;
import org.domain.service.EmpService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by root on 3/20/19.
 */
@SpringBootApplication
@EnableJpaRepositories
public class MainApp {

    public static void main(String[] args){

        ConfigurableApplicationContext context = SpringApplication.run(MainApp.class, args);

        DeptService deptService = context.getBean(DeptService.class);
        DeptDto deptDto = new DeptDto();
        deptDto.setDeptName("D1");
        deptService.save(deptDto);

        EmpService empService = context.getBean(EmpService.class);
        EmpDto empDto = new EmpDto();
        empDto.setDeptID(1L);
        empDto.setAddress("Taiwan");
        empDto.setAge(30);
        empDto.setEmpName("Jamari");
        empDto.setEmpPhone("12345678");
        empDto.setGender("male");

        empService.save(empDto);
    }
}
