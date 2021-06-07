package rich.zrc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping(value = "/handle01")
    public String handle() {
        return "success";
    }

    /*
        需求在于，此时我们是配置了视图解析器的
        如果直接俄返回hello，那么视图解析器帮我们拼接的地址回事/WEB-INF/pages/hello.jsp
        然而实际上我们想访问的是Web目录下的hello.jsp，而且拼接出的路径下也没有hello.jsp
     */
    @RequestMapping(value = "/hello")
    public String hello() {
        // 我们可以使用forward前缀,forward:的意思就是转发到该页面
        return "forward:/hello.jsp";
    }

    @RequestMapping(value = "helloIII")
    public String helloIII() {
        // 我们也可以将这个请求使用forward前缀转发给另外一个处理器
        return "forward:/hello";
    }

    @RequestMapping(value = "/helloII")
    public String helloII() {
        // 可以使用相对路径来拼接这个串
        return "../../hello";
    }

    // 使用redirect重定向到hello.jsp
    @RequestMapping("/handle03")
    public String handle03() {
        // 对于原生的Servle由于重定向的地址是由浏览器解析，所以在写地址的时候必须加上项目名
        return "redirect:/hello.jsp";
    }

    @RequestMapping("/handle04")
    public String handle04() {
        return "redirect:/handle03";
    }
}

/*
    1.请求处理执行方法执行完成后，最终返回一个ModelAndView对象。对于那些返回String，View或ModelMap等类型的处理方法，SpringMVC也会
    在内部将它们装配成一个ModelAndView对象，它包含了逻辑名和模型对象的视图
    2.SpringMVC借助视图解析器得到最终的视图对象
    3.对于最终究竟采取何种视图对象对模型数据进行渲染，处理器并不关心，处理器工作中点聚集在生产模型数据的工作上，从而实现MVC的充分解耦
 */