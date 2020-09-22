<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/9/22
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--
    JSP文件内置对象：session
                类型：HttpSession
                作用：JSP文件在运行时，可以通过session指向当前用户的session，添加或1读取共享数据
-->

<!--将共享数据1添加到当前用户私人储物柜-->
<%
    session.setAttribute("key", 200);
%>
