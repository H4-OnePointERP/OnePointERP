package project.onepoint.erp.approval.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import project.onepoint.erp.approval.dto.res.DashBoardRes;
import project.onepoint.erp.approval.service.ApprovalService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ApprovalController {

    @Autowired
    ApprovalService approvalService;

    /**
     * 지출결의서 등록하는 API
     * @param request: session
     * @param ModelAndView: 지출결의서 상세보기 정보
     * @return: mv
     */
    @GetMapping("/approval/dashboard")
    public ModelAndView getDashBoard(HttpServletRequest request) {

        project.onepoint.erp.login.dto.res.EmpSession empSession = (project.onepoint.erp.login.dto.res.EmpSession) request.getSession().getAttribute(project.onepoint.erp.login.SessionConst.LOGIN_MEMBER);

        ModelAndView mv = new ModelAndView("dashboardform");

        DashBoardRes result = approvalService.getDashboard(empSession.getEmpSeq());

        mv.addObject("result", result);

        return mv;
    }

    @RequestMapping("/approval/register")
    public String viewRegister(){
        return "approval-form";
    }
}
