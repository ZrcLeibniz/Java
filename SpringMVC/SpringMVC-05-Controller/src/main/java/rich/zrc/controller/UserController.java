package rich.zrc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/User")
public class UserController {
    @RequestMapping("/t1")
    public String test1(@RequestParam("username") String name, Model model) {
        System.out.println("接收到的前端参数是：" + name);
        model.addAttribute("msg", name);
        return "test";
    }

    @RequestMapping("/t2")
    public String test2(User user, Model model) {
        System.out.println("接受到的前端参数是" + user);
        return "test";
    }
}
