package project.onepoint.erp.Form;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {

    @RequestMapping("/main.do")
    public ModelAndView viewMain(){

        ModelAndView mv = new ModelAndView("main");

        return mv;
    }

}
