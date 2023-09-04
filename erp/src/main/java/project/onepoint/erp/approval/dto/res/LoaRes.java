package project.onepoint.erp.approval.dto.res;

import lombok.Data;

@Data
public class LoaRes {
    private int empSeq;
    private int loaSeq;
    private int appSeq;
    private String loa_title;
    private String loa_text;
    private String appStatus;
    private String appType;
    private String approver;
    private String createdDT;
    private String empName;
}
