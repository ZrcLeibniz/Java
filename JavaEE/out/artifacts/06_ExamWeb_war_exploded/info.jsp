<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/9/24
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <%
        String info = request.getAttribute("info").toString();
    %>
    <font style="color:red; font-size: 40px"><%=info%></font>
</center>
</body>
</html>
