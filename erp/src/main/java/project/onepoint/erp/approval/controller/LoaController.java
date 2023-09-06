package project.onepoint.erp.approval.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import project.onepoint.erp.approval.dto.req.LoaReq;
import project.onepoint.erp.approval.dto.res.LoaRes;
import project.onepoint.erp.approval.service.ApprovalService;
import project.onepoint.erp.approval.service.LoaService;
import project.onepoint.erp.login.SessionConst;
import project.onepoint.erp.login.dto.res.EmpSession;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LoaController {

    private final ApprovalService approvalService;
    private final LoaService loaService;

    @GetMapping("/approval/loaForm")
    public ModelAndView openLeaveForm(@ModelAttribute("loaReq") LoaReq loaReq, HttpServletRequest request) {
        EmpSession empSession = (EmpSession) request.getSession().getAttribute(SessionConst.LOGIN_MEMBER);
        loaReq.setEmpName(empSession.getEmpName());

        ModelAndView mv = new ModelAndView("approval/loaForm");
        mv.addObject("approverList", approvalService.selectApproverList(empSession.getEmpSeq()));

        return mv;
    }

    @PostMapping("/approval/loa")
    public String insertLeave(@ModelAttribute LoaReq loaReq,
                              Model model, HttpServletRequest request) {

        EmpSession empSession = (EmpSession) request.getSession().getAttribute(SessionConst.LOGIN_MEMBER);
        loaReq.setEmpSeq(empSession.getEmpSeq());
        loaReq.setEmpName(empSession.getEmpName());

        LoaRes res = loaService.insertLoa(loaReq);

        if(res!=null) {
            model.addAttribute("loaRes", res);
            return "approval/loaDetail";
        } else {
            return "approval/loaForm";
        }
    }
}
