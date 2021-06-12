<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/6/7
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <%
        pageContext.setAttribute("ctp", "/SpringMVC_RestfulCRUD_war_exploded/");
    %>
</head>
<body>
    <h1>员工修改</h1>
    <form:form action="${ctp}emp/${employee.id}" modelAttribute="employee" method="post">
        <input type="hidden" name="_method" value="put"/>
        <input type="hidden" name="id" value="${employee.id}"/>
        email:<form:input path="email"/><br/>
        gender:&nbsp;&nbsp;&nbsp;
            男: <form:radiobutton path="gender" value="1"/>
            &nbsp;&nbsp;&nbsp;
        女: <form:radiobutton path="gender" value="0"/><br/>
        dept:<form:select path="department.id" items="${depts}" itemLabel="departmentName" itemValue="id"/><br/>
        <input type="submit" value="修改"/>
    </form:form>
</body>
</html>