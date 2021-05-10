package rich.zrc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import rich.zrc.service.RichService;

@Controller
public class RichController {
    @Autowired
    private RichService richService;

    public void print() {
        System.out.println(richService);
    }
}
