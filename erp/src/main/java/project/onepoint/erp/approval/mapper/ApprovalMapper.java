package project.onepoint.erp.approval.mapper;

import org.apache.ibatis.annotations.Mapper;
import project.onepoint.erp.approval.dto.req.AppStatusListReq;
import project.onepoint.erp.approval.dto.req.ApprovalReq;
import project.onepoint.erp.approval.dto.req.ApprovalStatusReq;
import project.onepoint.erp.approval.dto.res.ApproverRes;
import project.onepoint.erp.approval.dto.res.DashBoardRes;
import project.onepoint.erp.approval.dto.res.GetApprovalListRes;

import java.util.List;

@Mapper
public interface ApprovalMapper {

    int insertApproval(ApprovalReq req);
    DashBoardRes getDashBoard(int id);

    List<ApproverRes> selectApproverList(int empSeq);

    List<GetApprovalListRes> getApprovalStatusList(AppStatusListReq appStatusListReq);

    int updateAppStatus(ApprovalStatusReq approvalStatusReq);
}
