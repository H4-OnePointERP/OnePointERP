package project.onepoint.erp.approval.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import project.onepoint.erp.approval.dto.req.LoaReq;
import project.onepoint.erp.approval.dto.res.LoaRes;
import project.onepoint.erp.approval.service.LoaService;
import project.onepoint.erp.login.SessionConst;
import project.onepoint.erp.login.dto.res.EmpSession;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LoaController {

    private final LoaService loaService;

    @GetMapping("/approval/loaForm")
    public String openLeaveForm(@ModelAttribute("loaReq") LoaReq form, HttpServletRequest request) {
        EmpSession empSession = (EmpSession) request.getSession().getAttribute(SessionConst.LOGIN_MEMBER);
        form.setEmpName(empSession.getEmpName());
        return "loaForm";
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
