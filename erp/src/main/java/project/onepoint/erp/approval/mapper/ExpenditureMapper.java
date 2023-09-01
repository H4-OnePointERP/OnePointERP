package project.onepoint.erp.approval.mapper;

import org.apache.ibatis.annotations.Mapper;
import project.onepoint.erp.approval.dto.req.ExpenditureReq;
import project.onepoint.erp.approval.dto.res.ExpenditureRes;

@Mapper
public interface ExpenditureMapper {

    int insertExpenditure(ExpenditureReq req);

    ExpenditureRes selectExpenditureByAppSeq(int appSeq);
}
