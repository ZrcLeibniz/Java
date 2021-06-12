<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/6/7
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>员工添加</h1>
    <form action="emp" method="post">
        lastName: <input type="text" name="lastName"/><br/>
        email: <input type="text" name="email"/><br/>
        gender:<br/>
            男<input type="radio" name="gender" value="1"/>
            女<input type="radio" name="gender" value="0"/><br/>
        dept:
            <select name="department.id">
                <c:forEach items="${depts}" var="deptItem">
                    <option value="${deptItem.id}">${deptItem.departmentName}</option>
                </c:forEach>
            </select><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>