package zrc.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OneFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // 1.调用请求对象读取请求包中的uri，了解用户访问的资源文件
        String requestURI = request.getRequestURI();
        // 2.如果本次请求的资源文件与登录相关，此时应该无条件放行
        if (requestURI.indexOf("login") != -1 || "/myWeb/".equals(requestURI)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        // 3.如果本次请求访问的是其他资源文件，需要得到用户在服务器端的HttpSession
        HttpSession session = request.getSession(false);
        if (session != null) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        request.getRequestDispatcher("/login_error.html").forward(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
