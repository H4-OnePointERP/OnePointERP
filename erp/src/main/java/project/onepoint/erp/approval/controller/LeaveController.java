package project.onepoint.erp.approval.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import project.onepoint.erp.approval.dto.req.LeaveReq;
import project.onepoint.erp.approval.dto.res.LeaveRes;
import project.onepoint.erp.approval.service.LeaveService;
import project.onepoint.erp.login.SessionConst;
import project.onepoint.erp.login.dto.res.EmpSession;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LeaveController {

    private final LeaveService leaveService;

    @PostMapping("/approval/leave")
    public String insertLeave(@ModelAttribute LeaveReq leaveReq,
                              Model model, HttpServletRequest request) {

        EmpSession empSession = (EmpSession) request.getSession().getAttribute(SessionConst.LOGIN_MEMBER);
        leaveReq.setEmpSeq(empSession.getEmpSeq());

        LeaveRes res = leaveService.insertLeave(leaveReq);

        if(res!=null) {
            model.addAttribute("leaveRes", res);
            return "approval/leave-detail";
        } else {
            return "approval/leave";
        }
    }
}
