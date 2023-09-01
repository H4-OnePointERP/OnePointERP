package project.onepoint.erp.approval.dto.req;

import lombok.Data;

@Data
public class ExpenditureReq {

    private int empSeq;

    private int appSeq;

    private String erTitle;

    private String erText;

    private String erAmount;

    private String erDt;

    private String approver;

}
