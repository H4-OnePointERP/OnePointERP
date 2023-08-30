package project.onepoint.erp.login.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.onepoint.erp.login.dto.req.LoginReq;
import project.onepoint.erp.login.dto.res.EmpSession;
import project.onepoint.erp.login.model.Employee;
import project.onepoint.erp.login.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    public static final String LOGIN_MEMBER = "emp";
    private final LoginService loginService;

    @GetMapping("/")
    public String loginForm(@ModelAttribute("loginReq") LoginReq form){
        return "login/loginForm";
    }


    @PostMapping("/login")
    public String getMember(@Valid @ModelAttribute LoginReq form, BindingResult bindingResult,
                           HttpServletRequest request){

        if(bindingResult.hasErrors()){
            return "login/loginForm";
        }

        Employee emp = loginService.getEmployee(form);
        log.info("login? {}", emp);

        if(emp == null){
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/loginForm";
        }

        HttpSession session = request.getSession();
        EmpSession empSession = EmpSession.builder()
                                .empSeq(emp.getEmpSeq())
                                .empId(emp.getEmpId())
                                .empName(emp.getEmpName())
                                .build();
        session.setAttribute(LOGIN_MEMBER, empSession);

       return "redirect:/main";
    }


    @PostMapping("/logout")
    public String logout(HttpServletRequest request){

        //세션을 삭제한다.
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }
        return "redirect:/";
    }


}

