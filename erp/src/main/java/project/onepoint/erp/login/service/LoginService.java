package project.onepoint.erp.login.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.onepoint.erp.login.dto.req.LoginReq;
import project.onepoint.erp.login.mapper.LoginMapper;
import project.onepoint.erp.login.model.Employee;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginMapper loginMapper;

    public Employee getEmployee(LoginReq loginReq){

        return loginMapper.selectEmployee(loginReq);
    }

}
