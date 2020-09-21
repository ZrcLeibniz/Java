package zrc.filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class OneFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /*
    http://localhost:8080/myWeb/mm.jpg?age=89
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 1.通过拦截请求对象得到请求包参数信息
        Integer age = Integer.parseInt(servletRequest.getParameter("age"));
        // 2.根据年龄1，帮助1Http服务器判断本次请求合法性
        if (age < 70) {
            // 合法请求，将请求放行
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            // 过滤器代替Http服务器拒绝本次请求
            servletResponse.setContentType("text/html;charset=utf-8");
            PrintWriter writer = servletResponse.getWriter();
            writer.print("<center><font style='color:red; font-size=40ox'>年龄大了，血管老化，不要看这些刺激的</font></center>");
        }
    }

    @Override
    public void destroy() {

    }
}
