package project.onepoint.erp.approval.dto.res;

import lombok.Data;


import java.time.LocalDateTime;

@Data
public class ExpenditureRes {

    private int empSeq;

    private String empName;

    private LocalDateTime createdDt;

    private String erTitle;

    private String approver;

    private LocalDateTime erDt;

    private String erText;

    private int erAmount;

    private String appStatus;

    private String rejectReason;

    private String appType;








}
