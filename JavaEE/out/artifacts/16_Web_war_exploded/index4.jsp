<%@ page import="zrc.entity.Student" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/9/22
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Student student = new Student(10, "Mike");
%>

学员编号：<%=student.getId()%> <br/>
学员姓名：<%=student.getName()%>