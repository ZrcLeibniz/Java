<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/9/22
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int num1 = 100;
    int num2 = 200;
%>

<!--在JSP文件中，通过输出标记，通知JSP将Java变量值写入响应体中-->
变量num1的值：<%=num1%>
变量num2的值：<%=num2%>

<!--执行标记还可以通知JSP将运算结果写入到响应体中-->
num1 + num2 = <%=num1 + num2%>