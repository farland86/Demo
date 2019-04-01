package org.domain.model;

import org.apache.commons.lang3.StringUtils;
import org.domain.dto.DeptDto;

import javax.persistence.*;

/**
 * Created by root on 3/20/19.
 */

@Entity
@Table(name = "dept")
public class Dept implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "dept_id")
    private Long deptID;

    @Column(name = "dept_name")
    private String deptName;

    public Dept() {
    }

    public Dept(DeptDto dto){
        this.deptName = dto.getDeptName();
    }

    public Dept(Long deptID, String deptName) {
        this.deptID = deptID;
        this.deptName = deptName;
    }

    public Long getDeptID() {
        return deptID;
    }

    public void setDeptID(Long deptID) {
        this.deptID = deptID;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public boolean validate(Dept dept){
        if(dept.getDeptID() == null || StringUtils.isBlank(dept.getDeptName())){
        	return false;
        }
        return true;
    }
}
