package project.onepoint.erp.approval.dto.res;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LeaveRes {

    private int empSeq;
    private int leaveSeq;
    private int appSeq;
    private String leaveType;
    private String leaveText;
    private LocalDate leaveStDt;
    private LocalDate leaveEndDt;
    private String approver;
    private String appStatus;
    private String appType;
    private String createdDT;
    private String empName;
}
