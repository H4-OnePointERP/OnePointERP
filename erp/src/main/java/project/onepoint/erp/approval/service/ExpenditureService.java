package project.onepoint.erp.approval.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.onepoint.erp.approval.dto.req.ApprovalReq;
import project.onepoint.erp.approval.dto.req.ExpenditureReq;
import project.onepoint.erp.approval.dto.res.ExpenditureRes;
import project.onepoint.erp.approval.mapper.ExpenditureMapper;


@Service
@RequiredArgsConstructor
public class ExpenditureService {

    private final ApprovalService approvalService;
    private final ExpenditureMapper expenditureMapper;

    /**
     * 지출결의서 등록하는 API
     * @param req: 지출결의서 작성 DTO
     * @return
     */
    public ExpenditureRes insertExpenditure(ExpenditureReq req) {
        ApprovalReq approvalReq = ApprovalReq.builder()
                .empSeq(req.getEmpSeq())
                .approver(req.getApprover())
                .appStatus("승인대기")
                .appType("expenditure").build();
        if (approvalService.insertApproval(approvalReq) == 1) {
            req.setAppSeq(approvalReq.getAppSeq());
            if (expenditureMapper.insertExpenditure(req) == 1) {
                return selectExpenditureByAppSeq(req.getAppSeq());
            }
        }
        return null;
    }

        public ExpenditureRes selectExpenditureByAppSeq(int appSeq){
        return expenditureMapper.selectExpenditureByAppSeq(appSeq);

    }
}
