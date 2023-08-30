package project.onepoint.erp.login.model;

import lombok.Data;


@Data
public class Employee {

    private int empSeq;
    private String empId;
    private String empPassword;
    private String empName;
    private String empGrade;

}