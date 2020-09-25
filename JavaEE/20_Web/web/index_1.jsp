<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/9/25
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Integer sid = (Integer) application.getAttribute("sid");
    String sname = (String) session.getAttribute("sname");
    String home = (String) request.getAttribute("home");
%>

学员ID:<%=sid%>
学员姓名:<%=sname%>
学院家乡:<%=home%>
<br/>
学员ID:${applicationScope.sid}
学员姓名:${sessionScope.sname}
学院家乡:${requestScope.home}
<br/>
学员ID:${requestScope.key.id}
学员姓名:${requestScope.key.name}
<br/>
学员ID:${key.id}
学员姓名:${key.name}
<br/>
计算结果：${key1 + key2}
比较大小：${key1 > key2?"欢迎光临":"谢绝入内"}
</body>
</html>
