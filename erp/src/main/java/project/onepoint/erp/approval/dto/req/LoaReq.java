package project.onepoint.erp.approval.dto.req;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LoaReq {
    private int empSeq;
    private int loaSeq;
    private int appSeq;
    private String loaTitle;
    private String loaText;
    private String appStatus;
    private String appType;
    private String approver;
    private LocalDateTime createdDT;
    private String empName;
}
