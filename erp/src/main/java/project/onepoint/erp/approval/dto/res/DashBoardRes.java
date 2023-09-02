package project.onepoint.erp.approval.dto.res;

import lombok.Data;
    @Data
    public class DashBoardRes {
        private int waitingApprovalCount;
        private int pendingApprovalCount;
        private int rejectedApprovalCount;
    }
