package project.onepoint.erp.approval.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import project.onepoint.erp.approval.dto.req.ApprovalStatusReq;
import project.onepoint.erp.approval.dto.req.AppStatusListReq;
import project.onepoint.erp.approval.dto.res.DashBoardRes;
import project.onepoint.erp.approval.dto.res.GetApprovalListRes;
import project.onepoint.erp.approval.service.ApprovalService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ApprovalController {

    private final ApprovalService approvalService;

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
        return "approvalForm";
    }

    @GetMapping("/approval/list")
    public ModelAndView getApprovalStatusList(@RequestParam String status, HttpServletRequest request) {

        AppStatusListReq appStatusListReq = new AppStatusListReq();

        appStatusListReq.setStatus(status);

        ModelAndView mv = new ModelAndView("approvalTypeListForm");

        project.onepoint.erp.login.dto.res.EmpSession empSession = (project.onepoint.erp.login.dto.res.EmpSession) request.getSession().getAttribute(project.onepoint.erp.login.SessionConst.LOGIN_MEMBER);

        appStatusListReq.setEmpSeq(empSession.getEmpSeq());

        List<GetApprovalListRes> result = approvalService.getApprovalStatusList(appStatusListReq);

        mv.addObject("type", appStatusListReq.getStatus());

        mv.addObject("approvals", result);

        return mv;
    }



    @PostMapping("/approval/{appStatus}")
    public String setAppApprove(@PathVariable String appStatus,
                                @ModelAttribute ApprovalStatusReq approvalStatusReq){

        approvalStatusReq.setAppStatus(appStatus);
        int res = approvalService.updateAppStatus(approvalStatusReq);

        log.info("-------승인 반려{}", res);

        return "redirect:/approval/list?status=승인요청";
    }

}
