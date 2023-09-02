package project.onepoint.erp.approval.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.onepoint.erp.approval.dto.res.DashBoardRes;
import project.onepoint.erp.approval.mapper.ApprovalMapper;
import project.onepoint.erp.approval.dto.req.ApprovalReq;

@Service
@RequiredArgsConstructor
public class ApprovalService {

    private final ApprovalMapper approvalMapper;

    public int insertApproval(ApprovalReq req){
        return approvalMapper.insertApproval(req);
    }

    public DashBoardRes getDashboard(int id) {

        return approvalMapper.getDashBoard(id);
    }
}
