package project.onepoint.erp.approval.dto.res;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class LeaveRes {

    private int empSeq;
    private int leaveSeq;
    private int appSeq;
    private String leaveType;
    private String leaveText;
    private String leaveStDt;
    private String leaveEndDt;
    private String approver;
    private String appStatus;
    private String appType;
    private String createdDT;
    private String empName;
    private String rejectReason;
}
