package project.onepoint.erp.approval.mapper;

import org.apache.ibatis.annotations.Mapper;
import project.onepoint.erp.approval.dto.req.ApprovalReq;

@Mapper
public interface ApprovalMapper {

    int insertApproval(ApprovalReq req);
}
