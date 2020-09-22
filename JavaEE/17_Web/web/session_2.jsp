<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/9/22
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--拿到session对象中的共享数据-->

<%
    Integer key = (Integer) session.getAttribute("key");
%>

<%=key%>
