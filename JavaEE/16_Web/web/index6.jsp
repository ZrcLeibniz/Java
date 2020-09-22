<%@ page import="zrc.entity.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/9/22
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Student mike = new Student(100, "Mike");
    Student smith = new Student(200, "Smith");
    Student tom = new Student(300, "Tom");
    List<Student> arrayList = new ArrayList<Student>();
    arrayList.add(mike);
    arrayList.add(smith);
    arrayList.add(tom);
%>

<!--集合的遍历输出-->
<table border="2" align="center">
    <tr>
        <td>学生编号</td>
        <td>学生姓名</td>
    </tr>
    <%
        for (Student student:arrayList) {
    %>
    <tr>
        <td><%=student.getId()%></td>
        <td><%=student.getName()%></td>
    </tr>
    <%
        }
    %>
</table>
