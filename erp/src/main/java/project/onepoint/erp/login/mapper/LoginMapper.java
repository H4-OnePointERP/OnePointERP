package project.onepoint.erp.login.mapper;

import org.apache.ibatis.annotations.Mapper;
import project.onepoint.erp.login.dto.req.LoginReq;
import project.onepoint.erp.login.model.Employee;

@Mapper
public interface LoginMapper {

    Employee selectEmployee(LoginReq form);
}
