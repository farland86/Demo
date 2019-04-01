package org.domain.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



/**
 * Created by root on 3/20/19.
 */

public class EmpDto {

    private Long empID;

    @NotEmpty(message = "請輸入名字")
    private String empName;

    private Long deptID;

    private String deptName;

    @NotEmpty(message = "請輸入性別")
    private String gender;

    @NotEmpty(message = "請輸入電話")
    private String empPhone;

    @NotEmpty(message = "請輸入地址")
    private String address;

    @NotNull(message = "請輸入年齡")
    private Integer age;

    private String createDate;

    private String lastModifyDate;

    private Integer page;

    private Integer size;

    public EmpDto(){
    }

    public EmpDto(Long empID, String empName, Long deptID, String gender, String empPhone, String address, Integer age, String createDate, String lastModifyDate) {
        this.empID = empID;
        this.empName = empName;
        this.deptID = deptID;
        this.gender = gender;
        this.empPhone = empPhone;
        this.address = address;
        this.age = age;
        this.createDate = createDate;
        this.lastModifyDate = lastModifyDate;
    }

    public Long getEmpID() {
        return empID;
    }

    public void setEmpID(Long empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Long getDeptID() {
        return deptID;
    }

    public void setDeptID(Long deptID) {
        this.deptID = deptID;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(String lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    
    public boolean updateValidate(EmpDto dto){
        if(dto.getEmpID() == null){
            return false;
        }

        return true;
    }

    public boolean findValidate(EmpDto dto){

        if(dto.getPage() == null || dto.getPage() < 1 || dto.getSize() == null || dto.getSize() < 1 || dto.getSize() > 10){
            return false;
        }

        if(dto.getEmpName() != null || dto.getEmpID() != null || dto.getAge() != null || dto.getDeptName() != null) {
        	return true;
        }

        return false;
    }
}
