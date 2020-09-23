<%@ page import="java.util.ArrayList" %>
<%@ page import="zrc.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/9/23
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 从请求域对象得到OneServlet添加进去的集合
    ArrayList<Student> student = (ArrayList) request.getAttribute("student");
%>

<table border="2px" align="center">
    <tr>
        <td>学生编号</td>
        <td>学生姓名</td>
    </tr>
    <%
        for (Student stu:student) {
    %>
    <tr>
        <td><%=stu.getId()%></td>
        <td><%=stu.getName()%></td>
    </tr> 
    <%
        }
    %>
</table>