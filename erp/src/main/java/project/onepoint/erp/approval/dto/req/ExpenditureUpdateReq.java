package project.onepoint.erp.approval.dto.req;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ExpenditureUpdateReq {

    private int appSeq;

    private String erTitle;

    private int approver;

    private String erDt;

    private String erText;

    private int erAmount;

    private String empName;

    private String createdDt;

    private String appStatus;

    private String rejectReason;



}
