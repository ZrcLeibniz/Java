package rich.zrc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import rich.zrc.service.RichService;

@Controller
public class RichServlet {
    @Autowired
    private RichService richService;

    public void richServlet() {
        System.out.println("来来来，自动注入大法好");
        richService.richService();
    }
}
