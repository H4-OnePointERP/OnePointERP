package project.onepoint.erp.approval.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import project.onepoint.erp.approval.dto.req.ExpenditureReq;
import project.onepoint.erp.approval.dto.res.ExpenditureRes;
import project.onepoint.erp.approval.service.ApprovalService;
import project.onepoint.erp.approval.service.ExpenditureService;
import project.onepoint.erp.login.SessionConst;

import javax.servlet.http.HttpServletRequest;
import project.onepoint.erp.login.dto.res.EmpSession;

@RequiredArgsConstructor
@Controller
public class ExpenditureController {

    private final ExpenditureService expenditureService;
    private final ApprovalService approvalService;


    /**
     * 지출결의서 등록하는 API
     * @param expenditureReq: 지출결의서 등록 DTO
     * @param model: 지출결의서 상세보기 정보
     * @return: view
     */
    @PostMapping("/approval/expenditure")
    public String insertExpenditure(@ModelAttribute("expenditureReq") ExpenditureReq expenditureReq,
                                    Model model, HttpServletRequest request){

        EmpSession empSession = (EmpSession) request.getSession().getAttribute(SessionConst.LOGIN_MEMBER);
        expenditureReq.setEmpSeq(empSession.getEmpSeq());

        ExpenditureRes res = expenditureService.insertExpenditure(expenditureReq);
        res.setEmpName(empSession.getEmpName());
        if(res!=null){
            model.addAttribute("expenditureRes",res);
            return "approval/expenditureDetail";
        }else {
            return "approval/expenditureForm";
        }

    }

    /**
     * 지출결의서 폼에 결재자 리스트 보내주는 API
     * @param expenditureReq: 지출결의서 폼 입력 DTO
     * @param request: seesion 값
     * @return: 지출결의서 폼 view + 결재자 리스트 model
     */
    @GetMapping("/approval/expenditureForm")
    public ModelAndView openExpenditureForm(@ModelAttribute("expenditureReq") ExpenditureReq expenditureReq, HttpServletRequest request){
        EmpSession empSession = (EmpSession) request.getSession().getAttribute(SessionConst.LOGIN_MEMBER);
        expenditureReq.setEmpName(empSession.getEmpName());

        ModelAndView mv = new ModelAndView("approval/expenditureForm");
        mv.addObject("approverList",approvalService.selectApproverList(empSession.getEmpSeq()));

        return mv;
    }



}
