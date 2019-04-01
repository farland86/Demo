package org.domain.service;

import java.util.List;

import org.domain.dto.DeptDto;
import org.domain.model.Dept;

/**
 * Created by root on 3/20/19.
 */
public interface DeptService {
    void save(DeptDto dto);
    void update(DeptDto dto);
    void delete(long deptID);
    List<Dept> find();
}
