package project.onepoint.erp.approval.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import project.onepoint.erp.approval.dto.req.LeaveReq;
import project.onepoint.erp.approval.dto.res.LeaveRes;
import project.onepoint.erp.approval.service.ApprovalService;
import project.onepoint.erp.approval.service.LeaveService;
import project.onepoint.erp.login.SessionConst;
import project.onepoint.erp.login.dto.res.EmpSession;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor

public class LeaveController {

    private final ApprovalService approvalService;
    private final LeaveService leaveService;

    @GetMapping("/approval/leaveForm")
    public ModelAndView openLeaveForm(@ModelAttribute("leaveReq") LeaveReq leaveReq, HttpServletRequest request) {
        EmpSession empSession = (EmpSession) request.getSession().getAttribute(SessionConst.LOGIN_MEMBER);
        leaveReq.setEmpName(empSession.getEmpName());

        ModelAndView mv = new ModelAndView("approval/leaveForm");
        mv.addObject("approverList", approvalService.selectApproverList(empSession.getEmpSeq()));
        return mv;
    }

    @PostMapping("/approval/leave")
    public String insertLeave(@ModelAttribute("leaveReq") LeaveReq leaveReq,
                              Model model, HttpServletRequest request) {

        EmpSession empSession = (EmpSession) request.getSession().getAttribute(SessionConst.LOGIN_MEMBER);
        leaveReq.setEmpSeq(empSession.getEmpSeq());
        leaveReq.setEmpName(empSession.getEmpName());

        LeaveRes res = leaveService.insertLeave(leaveReq);
        res.setEmpName(empSession.getEmpName());

        if(res!=null) {
            model.addAttribute("leaveRes", res);
            return "approval/leaveDetail";
        } else {
            return "approval/leaveForm";
        }
    }
}
