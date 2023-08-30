package project.onepoint.erp.approval.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import project.onepoint.erp.approval.service.LeaveService;

@Controller
public class LeaveController {
    @Autowired
    private LeaveService leaveService;

    @GetMapping("/approval/leave")
    public String openLeaveForm() {
        return "/leave";
    }

    @PostMapping("/approval/leave")
    public ModelAndView registerLeave() {
        ModelAndView mv = new ModelAndView("/approval/leave-detail");
        ApprovalReq req = leaveService.registerLeave();
        mv.addObject(req);

        return mv;
    }
}
