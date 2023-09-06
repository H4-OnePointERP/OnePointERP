package project.onepoint.erp.approval.dto.res;

import lombok.Data;

@Data
public class GetApprovalListRes {
    private int appSeq;
    private String empName;
    private String appStatus;
    private String appType;
    private String createDate;
}
