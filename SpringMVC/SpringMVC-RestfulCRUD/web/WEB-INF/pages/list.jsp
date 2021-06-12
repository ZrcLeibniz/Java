<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/6/7
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    pageContext.setAttribute("ctp", request.getContextPath());
%>
<html>
<head>
    <title>员工列表页面</title>
</head>
<body>
    <h1>员工列表</h1>
    <table border="1" cellpadding="5" cellspacing="0">
        <tr>
            <th>ID</th>
            <th>lastName</th>
            <th>email</th>
            <th>gender</th>
            <th>departmentName</th>
            <th>EDIT</th>
            <th>DELETE</th>
        </tr>
        <c:forEach items="${emps}" var="emp">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.lastName}</td>
            <td>${emp.email}</td>
            <td>${emp.gender == 0 ? "女" : "男"}</td>
            <td>${emp.department.departmentName}</td>
            <td>
                <a href="/SpringMVC_RestfulCRUD_war_exploded/emp/${emp.id}">修改</a>
            </td>
            <td>
                <form action="/SpringMVC_RestfulCRUD_war_exploded/emp/${emp.id}" method="post">
                    <input type="hidden" name="_method" value="delete"/>
                    <input type="submit" value="删除"/>
                </form>
            </td>
        </tr>
        </c:forEach>
    </table>
    <a href="/SpringMVC_RestfulCRUD_war_exploded/toaddpage">添加员工</a>
</body>
</html>
