package org.domain.repository;

import org.domain.model.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by root on 3/20/19.
 */
public interface EmpRepository extends JpaRepository<Emp, Long>, JpaSpecificationExecutor<Emp> {
}