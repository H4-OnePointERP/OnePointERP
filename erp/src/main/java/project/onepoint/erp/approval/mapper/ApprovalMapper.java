package project.onepoint.erp.approval.mapper;

import org.apache.ibatis.annotations.Mapper;
import project.onepoint.erp.approval.dto.req.ApprovalReq;
import project.onepoint.erp.approval.dto.res.DashBoardRes;

@Mapper
public interface ApprovalMapper {

    int insertApproval(ApprovalReq req);
    DashBoardRes getDashBoard(int id);
}
