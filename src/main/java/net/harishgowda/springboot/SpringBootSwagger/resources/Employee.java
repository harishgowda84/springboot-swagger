package net.harishgowda.springboot.SpringBootSwagger.resources;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details of an employee")
public class Employee {

    @ApiModelProperty(notes="Employee id")
    private String empid;
    @ApiModelProperty(notes="Employee name")
    private String empName;
    @ApiModelProperty(notes="Employee salary")
    private int salary;

    public Employee(String empid, String empName, int salary) {
        this.empid = empid;
        this.empName = empName;
        this.salary = salary;
    }

    public String getEmpid() {
        return empid;
    }

    public String getEmpName() {
        return empName;
    }

    public int getSalary() {
        return salary;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
