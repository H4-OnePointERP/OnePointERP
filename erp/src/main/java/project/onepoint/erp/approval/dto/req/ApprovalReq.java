package project.onepoint.erp.approval.dto.req;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class ApprovalReq {

    private int appSeq;

    private int empSeq;

    private String approver;

    private String appStatus;

    private String appType;

}
