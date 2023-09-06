package project.onepoint.erp.approval.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.onepoint.erp.approval.dto.req.ApprovalReq;
import project.onepoint.erp.approval.dto.req.LoaReq;
import project.onepoint.erp.approval.dto.res.LoaRes;
import project.onepoint.erp.approval.mapper.LoaMapper;

@RequiredArgsConstructor
@Service
public class LoaService {

    private final ApprovalService approvalService;
    private final LoaMapper loaMapper;

    public LoaRes insertLoa(LoaReq req) {
        ApprovalReq approvalReq = ApprovalReq.builder()
                .empSeq(req.getEmpSeq())
                .approver(req.getApprover())
                .appStatus("승인대기")
                .appType("loa").build();
        if (approvalService.insertApproval(approvalReq) == 1) {
            req.setAppSeq(approvalReq.getAppSeq());
            if (loaMapper.insertLoa(req) == 1) {
                return selectLoaByAppSeq(req.getAppSeq());
            }
        }
        return null;
    }

    public LoaRes selectLoaByAppSeq(int appSeq) {
        return loaMapper.selectLoaByAppSeq(appSeq);
    }
}
