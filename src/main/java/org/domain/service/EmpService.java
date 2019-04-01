package org.domain.service;

import org.domain.dto.EmpDto;
import org.domain.model.Emp;

import java.util.List;

/**
 * Created by root on 3/20/19.
 */
public interface EmpService {
    void save(EmpDto dto);
    void update(EmpDto dto);
    void delete(Long empID);
    List<Emp> findEmp(EmpDto dto);
}
