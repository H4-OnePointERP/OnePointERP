package project.onepoint.erp.approval.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import project.onepoint.erp.approval.dto.req.ExpenditureReq;
import project.onepoint.erp.approval.dto.res.ExpenditureRes;
import project.onepoint.erp.approval.service.ExpenditureService;
import project.onepoint.erp.login.SessionConst;

import javax.servlet.http.HttpServletRequest;
import project.onepoint.erp.login.dto.res.EmpSession;

@RequiredArgsConstructor
@Controller
public class ExpenditureController {

    private final ExpenditureService expenditureService;


    /**
     * 지출결의서 등록하는 API
     * @param expenditureReq: 지출결의서 등록 DTO
     * @param model: 지출결의서 상세보기 정보
     * @return: view
     */
    @PostMapping("/approval/expenditure")
    public String insertExpenditure(@ModelAttribute ExpenditureReq expenditureReq,
                                    Model model, HttpServletRequest request){

        EmpSession empSession = (EmpSession) request.getSession().getAttribute(SessionConst.LOGIN_MEMBER);
        expenditureReq.setEmpSeq(empSession.getEmpSeq());

        ExpenditureRes res = expenditureService.insertExpenditure(expenditureReq);
        if(res!=null){
            model.addAttribute("expenditureRes",res);
            return "approval/expenditureDetail";
        }else {
            return "approval/expenditureForm";
        }

    }




}
