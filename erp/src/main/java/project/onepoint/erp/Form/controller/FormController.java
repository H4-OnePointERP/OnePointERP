package project.onepoint.erp.Form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {

    @RequestMapping("/dashboard")
    public ModelAndView viewMain(){

        ModelAndView mv = new ModelAndView("dashboard");

        return mv;
    }

}
