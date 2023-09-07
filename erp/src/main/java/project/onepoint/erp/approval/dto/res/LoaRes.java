package project.onepoint.erp.approval.dto.res;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LoaRes {
    private int empSeq;
    private int loaSeq;
    private int appSeq;
    private String loaTitle;
    private String loaText;
    private String appStatus;
    private String appType;
    private String approver;
    private String createdDT;
    private String empName;
    private String rejectReason;
}
