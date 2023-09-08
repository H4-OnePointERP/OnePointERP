package project.onepoint.erp.approval.dto.req;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ExpenditureReq {

    private int erSeq;

    private int empSeq;

    private int appSeq;

    private String empName;

    private String erTitle;

    private String erText;

    private String erAmount;

    private String erDt;

    private int approver;

}
