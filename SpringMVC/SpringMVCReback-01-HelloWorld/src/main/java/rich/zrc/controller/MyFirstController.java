package rich.zrc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
    1.告诉SpringMVC这是一个处理器，可以处理请求
    2.绑定请求对应的方法
 */
@Controller
public class MyFirstController {

    /*
        1.客户端通过点击链接会发送http://localhost:8080/springmvc/hell请求
        2.请求到达tomcat服务器
        3.SpringMVC的前段控制器收到所有请求
        4.来看请求地址和@RequestMapping标注的那个方法匹配，来找到底使用哪个类的哪个方法
        5.前端控制器找到了目标处理类和目标方法，直接利用反射执行目标方法
        6.拿到方法返回值之后，用试图解析器拼接完整的页面地址
        7.拿到页面地址，前端控制器帮我们请求转发至对应页面
     */
    @RequestMapping("/hello")
    public String myFirstRequest() {
        System.out.println("请求收到了");
        return "success";
    }
}
