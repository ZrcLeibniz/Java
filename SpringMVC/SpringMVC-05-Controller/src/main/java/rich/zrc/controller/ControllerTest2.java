package rich.zrc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/c2")
public class ControllerTest2 {

    @RequestMapping("/t1")
    public String test1(Model model) {
        model.addAttribute("msg", "HELLO");
        return "test";
    }

    @RequestMapping("/t2")
    public String test2(Model model) {
        model.addAttribute("msg", "HeLlO");
        return "test";
    }
}
