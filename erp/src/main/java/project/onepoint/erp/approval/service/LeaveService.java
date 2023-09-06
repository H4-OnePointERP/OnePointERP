package project.onepoint.erp.approval.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.onepoint.erp.approval.dto.req.ApprovalReq;
import project.onepoint.erp.approval.dto.req.LeaveReq;
import project.onepoint.erp.approval.dto.res.LeaveRes;
import project.onepoint.erp.approval.mapper.LeaveMapper;

@Service
@RequiredArgsConstructor
public class LeaveService {

    private final ApprovalService approvalService;
    private final LeaveMapper leaveMapper;

    public LeaveRes insertLeave(LeaveReq req) {
        ApprovalReq approvalReq = ApprovalReq.builder()
                .empSeq(req.getEmpSeq())
                .approver(req.getApprover())
                .appStatus("승인대기")
                .appType("APP_LEAVE").build();
        if (approvalService.insertApproval(approvalReq) == 1) {
            req.setAppSeq(approvalReq.getAppSeq());
            if (leaveMapper.insertLeave(req) == 1) {
                return selectLeaveByAppSeq(req.getAppSeq());
            }
        }
        return null;
    }

    public LeaveRes selectLeaveByAppSeq(int appSeq) {
        return leaveMapper.selectLeaveByAppSeq(appSeq);
    }
}
