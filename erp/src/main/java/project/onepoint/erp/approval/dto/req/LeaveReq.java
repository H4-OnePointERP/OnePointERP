package project.onepoint.erp.approval.dto.req;

import lombok.Data;

@Data
public class LeaveReq {

    private int empSeq;
    private Date appDt;
    private String approver;
    private String leaveType;
    private String leaveText;
    private Date leaveStDt;
    private Date leaveEndDt;
}
