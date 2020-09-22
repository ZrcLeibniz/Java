<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/9/22
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--
    JSP文件内置对象：request
            类型：HttpServletRequest
            作用：在JSP文件运行时读取请求包信息；与Servlet在请求转发过程中实现数据共享
-->

<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
%>

来访用户姓名：<%=username%>
来访者密码：<%=password%>