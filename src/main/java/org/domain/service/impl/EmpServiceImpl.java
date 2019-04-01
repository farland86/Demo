package org.domain.service.impl;

import org.domain.dto.EmpDto;
import org.domain.model.Emp;
import org.domain.repository.DeptRepository;
import org.domain.repository.EmpRepository;
import org.domain.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by root on 3/20/19.
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpRepository empRepository;

    @Autowired
    private DeptRepository deptRepository;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public void save(EmpDto dto) {
        Emp emp = new Emp(dto);

        emp.setDept(deptRepository.getOne(dto.getDeptID()));

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        emp.setCreateDate(dateFormat.format(date));
        emp.setLastModifyDate(dateFormat.format(date));

        empRepository.save(emp);
    }

    @Override
    public void update(EmpDto dto) {
        Optional<Emp> old = empRepository.findById(dto.getEmpID());
        
        if(!old.isPresent()){
            throw new RuntimeException("Can not find this employee.");
        }
        
        Emp emp = new Emp(dto);
        emp.setEmpID(dto.getEmpID());
        emp.setDept(deptRepository.getOne(dto.getDeptID()));
        emp.setCreateDate(old.get().getCreateDate());
        emp.setLastModifyDate(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));

        empRepository.save(emp);
    }

    @Override
    public void delete(Long empID) {
    	
        if (empRepository.findById(empID) == null) {
        	throw new RuntimeException("Can not find this employee.");
        }
        empRepository.deleteById(empID);
    }

    public List<Emp> findEmp(EmpDto dto) {
        EntityManager em = entityManagerFactory.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Emp> cq = cb.createQuery(Emp.class);
        Root<Emp> emp = cq.from(Emp.class);

        List<Predicate> predicates = new ArrayList<>();

        if(dto.getEmpName() != null){
            predicates.add(cb.equal(emp.get("empName"), dto.getEmpName()));
        }
        if(dto.getEmpID() != null){
            predicates.add(cb.equal(emp.get("empID"), dto.getEmpID()));
        }
        if(dto.getAge() != null){
            predicates.add(cb.equal(emp.get("age"), dto.getAge()));
        }
        if(dto.getDeptID() != null){
            predicates.add(cb.equal(emp.get("dept").get("deptID"), dto.getDeptID()));
        }
        cq.where(predicates.toArray(new Predicate[0]));
        TypedQuery<Emp> typedQuery = em.createQuery(cq);
        typedQuery.setFirstResult((dto.getPage()-1) * dto.getSize());
        typedQuery.setMaxResults(dto.getSize());

        return typedQuery.getResultList();

    }
}
