package project.onepoint.erp.approval.dto.req;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class LeaveReq {

    private int empSeq;
    private int leaveSeq;
    private int appSeq;
    private String leaveType;
    private String leaveText;
    private String leaveStDt;
    private String leaveEndDt;
    private String approver;
    private LocalDateTime createdDT;
    private String empName;
}
