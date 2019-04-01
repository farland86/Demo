package org.domain.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.*;

/**
 * Created by root on 3/20/19.
 */

public class DeptDto {

	@NotNull(message = "請輸入部門編號")
	private Long deptID;
	 
	@NotEmpty(message = "請輸入舊部門名稱")
    private String deptName;
	
	@NotEmpty(message = "請輸入新部門名稱")
    private String deptOldName;

    public DeptDto() {
    }

    public DeptDto(String deptName) {
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

    public String getDeptOldName() {
        return deptOldName;
    }

    public void setDeptOldName(String deptOldName) {
        this.deptOldName = deptOldName;
    }

    public boolean addValidate(DeptDto dept){
        if(StringUtils.isBlank(dept.getDeptName())){
            return false;
        }
        return true;
    }
    
}
