package project.onepoint.erp.form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import project.onepoint.erp.login.SessionConst;
import project.onepoint.erp.login.dto.res.EmpSession;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FormController {

    @RequestMapping("/main")
    public String viewMain(){

        return "mainForm";
    }

    @RequestMapping("/menu")
    public ModelAndView viewMenu(HttpServletRequest request){

        ModelAndView mv = new ModelAndView("menuForm");
        EmpSession empSession = (EmpSession) request.getSession().getAttribute(SessionConst.LOGIN_MEMBER);
        mv.addObject("name", empSession.getEmpName());

        return mv;
    }

}