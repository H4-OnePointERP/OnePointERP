package project.onepoint.erp.approval.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.onepoint.erp.approval.dto.req.ApprovalReq;
import project.onepoint.erp.approval.dto.req.ExpenditureReq;
import project.onepoint.erp.approval.dto.req.ExpenditureUpdateReq;
import project.onepoint.erp.approval.dto.res.ExpenditureRes;
import project.onepoint.erp.approval.mapper.ApprovalMapper;
import project.onepoint.erp.approval.mapper.ExpenditureMapper;


@Service
@RequiredArgsConstructor
public class ExpenditureService {

    private final ApprovalService approvalService;
    private final ExpenditureMapper expenditureMapper;
    private final ApprovalMapper approvalMapper;

    /**
     * 지출결의서 등록하는 API
     * @param req: 지출결의서 작성 DTO
     * @return : 지출결의서 상세 응답 DTO
     */
    public ExpenditureRes insertExpenditure(ExpenditureReq req) {
        ApprovalReq approvalReq = ApprovalReq.builder()
                .empSeq(req.getEmpSeq())
                .approver(req.getApprover())
                .appStatus("승인대기")
                .appType("APP_ER").build();
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

    public ExpenditureRes updateExpenditure(ExpenditureUpdateReq expenditureUpdateReq) {
        if (expenditureMapper.updateExpenditure(expenditureUpdateReq) == 1) {
            if (approvalMapper.updateApproval(expenditureUpdateReq) == 1) {
                return selectExpenditureByAppSeq(expenditureUpdateReq.getAppSeq());
            }
        }
        return null;
    }
}
