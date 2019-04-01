package org.domain.model;

import org.domain.dto.EmpDto;

import javax.persistence.*;

/**
 * Created by root on 3/20/19.
 */
@Entity
@Table(name = "emp")
public class Emp implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "emp_id")
    @GeneratedValue
    private Long empID;

    @Column(name = "emp_name")
    private String empName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dept_id", nullable = false)
    private Dept dept;

    @Column(name = "gender")
    private String gender;

    @Column(name = "emp_phone")
    private String empPhone;

    @Column(name = "address")
    private String address;

    @Column(name = "age")
    private Integer age;

    @Column(name = "create_date")
    private String createDate;

    @Column(name = "last_modify_date")
    private String lastModifyDate;

    public Emp(){
    }

    public Emp(Long empID, String empName, Dept dept, String gender, String empPhone, String address, Integer age, String createDate, String lastModifyDate) {
        this.empID = empID;
        this.empName = empName;
        this.dept = dept;
        this.gender = gender;
        this.empPhone = empPhone;
        this.address = address;
        this.age = age;
        this.createDate = createDate;
        this.lastModifyDate = lastModifyDate;
    }

    public Emp(EmpDto dto){
        this.empName = dto.getEmpName();
        this.gender = dto.getGender();
        this.empPhone = dto.getEmpPhone();
        this.address = dto.getAddress();
        this.age = dto.getAge();
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

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
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

    public boolean validate(Dept dept){
        boolean result = true;
        if(dept.getDeptID() == null || dept.getDeptName() == null || dept.getDeptName().isEmpty()){
            result = false;
        }
        return result;
    }
}

