package zrc.filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class OneFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Integer age = Integer.parseInt(servletRequest.getParameter("age"));
        if (age < 70) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            servletResponse.setContentType("text/html;charset=utf-8");
            PrintWriter writer = servletResponse.getWriter();
            writer.print("<center><font style='color:red; font-size=40ox'>年龄大了，血管老化，不要看这些刺激的</font></center>");
        }
    }

    @Override
    public void destroy() {

    }
}
