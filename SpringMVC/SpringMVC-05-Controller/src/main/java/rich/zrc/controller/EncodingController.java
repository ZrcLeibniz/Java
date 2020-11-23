package rich.zrc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/e")
public class EncodingController {
    @RequestMapping("/t1")
    public String test1(@RequestParam String name, Model model) {
        model.addAttribute("msg", name);
        return "test";
    }
}
