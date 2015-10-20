<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: kuzin
  Date: 10/9/2015
  Time: 5:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%
  List<String> list= (List<String>) request.getAttribute("Names");
  String error= (String) request.getAttribute("error");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jbb</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/test" method="post">
  <label>
    <input type="text" name="Name">
  </label>
  <input type="submit" name="submit" value="OK">
</form>
<%if (error !=null && !error.isEmpty()) {%>
<p style="color:red"><%=error %></p>
<%}%>

<%if (list!=null && !list.isEmpty()) {%>
<ul>
  <%for (String s:list){%>
  <li><%=s%></li>
  <%}%>
</ul>
  <%}else {%>
  List is empty!
<%}%>
</body>
</html>