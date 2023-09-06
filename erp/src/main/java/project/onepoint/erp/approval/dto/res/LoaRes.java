package project.onepoint.erp.approval.dto.res;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LoaRes {
    private int empSeq;
    private int loaSeq;
    private int appSeq;
    private String loa_title;
    private String loa_text;
    private String appStatus;
    private String appType;
    private int approver;
    private LocalDateTime createdDT;
    private String empName;
}
