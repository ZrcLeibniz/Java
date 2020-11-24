package rich.zrc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import rich.zrc.pojo.User;

import java.util.Date;
import java.util.LinkedList;

@Controller
public class UserController {

    @RequestMapping("/json1")
    @ResponseBody
    public String json1(Model model) {
        User user = new User(1, "rich", 1);
        ObjectMapper mapper = new ObjectMapper();
        String s = null;
        try {
            s = mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
//        model.addAttribute("msg", user);
        return s;
    }

    @ResponseBody
    @RequestMapping("/json2")
    public String json2() {
        LinkedList<User> list = new LinkedList<>();
        User rich = new User(1, "rich", 1);
        User rich1 = new User(1, "rich", 1);
        User rich2 = new User(1, "rich", 1);
        User rich3 = new User(1, "rich", 1);
        list.add(rich);
        list.add(rich1);
        list.add(rich2);
        list.add(rich3);
        ObjectMapper mapper = new ObjectMapper();
        String s = null;
        try {
            s = mapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return s;
    }

    @ResponseBody
    @RequestMapping("/json3")
    public String json3() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        Date date = new Date();
        String s = null;
        try {
            s = mapper.writeValueAsString(date);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return s;
    }
}
