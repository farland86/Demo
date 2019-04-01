package org.domain.repository;

import org.domain.model.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by root on 3/20/19.
 */
public interface DeptRepository extends JpaRepository<Dept, Long> {

    @Query("from Dept d where d.deptName=:deptName")
    List<Dept> findByName(@Param("deptName") String deptName);
}
