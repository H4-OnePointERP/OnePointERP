package project.onepoint.erp.approval.mapper;

import org.apache.ibatis.annotations.Mapper;
import project.onepoint.erp.approval.dto.req.LeaveReq;
import project.onepoint.erp.approval.dto.res.LeaveRes;

@Mapper
public interface LeaveMapper {

    int insertLeave(LeaveReq req);

    LeaveRes selectLeaveByAppSeq(int appSeq);
}
