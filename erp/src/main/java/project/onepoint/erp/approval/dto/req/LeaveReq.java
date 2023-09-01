package project.onepoint.erp.approval.dto.req;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LeaveReq {

    private int empSeq;
    private int leaveSeq;
    private int appSeq;
    private String leaveType;
    private String leaveText;
    private LocalDate leaveStDt;
    private LocalDate leaveEndDt;
    private String appStatus;
    private String appType;
    private String approver;

}
