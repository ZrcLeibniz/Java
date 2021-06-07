package rich.zrc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// 为当前类的所有方法的请求地址指定一个基准路径
@RequestMapping("/haha")
public class RequestMappingTestController {
    @RequestMapping("/handle01")
    public String handle01() {
        System.out.println("RequestMappingTestController...handle01");
        return "success";
    }

    /*
        @RequestMapping的属性
            method: 用来限定请求方式，默认是全部接受
            params: 规定请求参数
                param1: 表示请求必须包含名为param1的参数
                !param1: 表示请求不能包含名为param1的参数
                param1 = value1: 表示请求包含名为param1的参数，且值必须为value1
                param1 != value1: 表示请求包含名为param1的请求参数，但是其值不能为value1
                该属性可以传一个数组，数组中的元素就是上述规则
            headers: 规定请求头，规则与上述相同，但是必须是请求头中存在的属性
            consumes: 只接收内容类型是哪种的请求，规定请求头中的content-type
            produces: 告诉浏览器返回的类型是是什么，给响应头中加上content-type
     */
    @RequestMapping(value = "handle02" )
    public String handle02() {
        return "success";
    }
}
