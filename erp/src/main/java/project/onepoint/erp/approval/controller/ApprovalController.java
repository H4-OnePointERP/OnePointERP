package project.onepoint.erp.approval.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import project.onepoint.erp.approval.dto.req.ApprovalStatusReq;
import project.onepoint.erp.approval.dto.req.AppStatusListReq;
import project.onepoint.erp.approval.dto.res.DashBoardRes;
import project.onepoint.erp.approval.dto.res.GetApprovalListRes;
import project.onepoint.erp.approval.service.ApprovalService;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import project.onepoint.erp.login.SessionConst;
import project.onepoint.erp.login.dto.res.EmpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ApprovalController {

    private final ApprovalService approvalService;

    /**
     * 지출결의서 등록하는 API
     * @param request: session
     * @return mv
     */
    @GetMapping("/approval/dashboard")
    public ModelAndView getDashBoard(HttpServletRequest request) {

        EmpSession empSession = (EmpSession) request.getSession().getAttribute(project.onepoint.erp.login.SessionConst.LOGIN_MEMBER);

        ModelAndView mv = new ModelAndView("approval/dashboardform");

        DashBoardRes result = approvalService.getDashboard(empSession.getEmpSeq());

        mv.addObject("result", result);

        return mv;
    }

    @RequestMapping("/approval/register")
    public String viewRegister(){
        return "approval/approvalForm";
    }

    /**
     * 승인대기, 승인, 반려 등 리스트에 따라 보여주는 API
     * @param request: httpservletRequest
     * @param status: approvalTypeListForm
     * @return mv
     */
    @GetMapping("/approval/list")
    public ModelAndView getApprovalStatusList(@RequestParam String status , HttpServletRequest request) {

        AppStatusListReq appStatusListReq = new AppStatusListReq();

        appStatusListReq.setStatus(status);

        ModelAndView mv = new ModelAndView("approval/approvalList");

        EmpSession empSession = (EmpSession) request.getSession().getAttribute(SessionConst.LOGIN_MEMBER);

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

        try {
            // 한글 문자열을 URL 인코딩
            String encodedStatus = URLEncoder.encode("승인요청", "UTF-8");

            // redirect URL에 인코딩된 문자열 포함
            return "redirect:/approval/list?status=" + encodedStatus;
        } catch (UnsupportedEncodingException e) {
            // 예외 처리 필요
            e.printStackTrace();
            return "redirect:/approval/list";
        }
    }
}