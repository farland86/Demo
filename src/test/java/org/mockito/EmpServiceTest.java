package org.mockito;

import org.domain.dto.DeptDto;
import org.domain.dto.EmpDto;
import org.domain.model.Dept;
import org.domain.model.Emp;
import org.domain.repository.DeptRepository;
import org.domain.service.impl.DeptServiceImpl;
import org.domain.service.impl.EmpServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by root on 3/22/19.
 */

@RunWith(MockitoJUnitRunner.class)
public class EmpServiceTest {
    private DeptDto deptDto;
    private EmpDto empDto;
    @Mock
    DeptServiceImpl ds;

    @Mock
    DeptRepository dr;

    @Mock
    EmpServiceImpl es;

    @Before
    public void setUp() throws Exception {
        deptDto = new DeptDto();
        deptDto.setDeptName("dept1");

        empDto = new EmpDto();
        empDto.setAddress("Taiwan");
        empDto.setAge(30);
        empDto.setEmpPhone("12345678");
        empDto.setGender("male");
        empDto.setEmpName("emp1");
        empDto.setDeptID(1L);
    }

    @Test
    public void testSave()  {

        ds.save(deptDto);

        Emp emp = new Emp(empDto);

        Dept dept = dr.getOne(empDto.getDeptID());
        emp.setDept(dept);

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        emp.setCreateDate(dateFormat.format(date));
        emp.setLastModifyDate(dateFormat.format(date));

        es.save(empDto);
    }

    @Test
    public void testUpdate()  {

        ds.save(deptDto);
        Emp emp = new Emp(empDto);

        Dept dept = dr.getOne(empDto.getDeptID());
        emp.setDept(dept);

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        emp.setCreateDate(dateFormat.format(date));
        emp.setLastModifyDate(dateFormat.format(date));

        es.save(empDto);

        EmpDto updateDto = new EmpDto();
        updateDto.setEmpID(1L);
        updateDto.setEmpName("emp2");

        es.update(updateDto);
    }

    @Test
    public void testDelete()  {
        ds.save(deptDto);
        es.delete(1L);
    }

    @Test
    public void testFindEmp()  {
        ds.save(deptDto);
        Emp emp = new Emp(empDto);

        Dept dept = dr.getOne(empDto.getDeptID());
        emp.setDept(dept);

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        emp.setCreateDate(dateFormat.format(date));
        emp.setLastModifyDate(dateFormat.format(date));

        es.save(empDto);
        EmpDto findDto = new EmpDto();
        findDto.setEmpName("Jamari");
        findDto.setPage(1);
        findDto.setSize(10);

        es.findEmp(findDto);
    }

}
