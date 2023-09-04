package project.onepoint.erp.approval.mapper;

import org.apache.ibatis.annotations.Mapper;
import project.onepoint.erp.approval.dto.req.LoaReq;
import project.onepoint.erp.approval.dto.res.LoaRes;

@Mapper
public interface LoaMapper {

    int insertLoa(LoaReq req);

    LoaRes selectLoaByAppSeq(int appSeq);
}
