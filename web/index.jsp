<%--
  Created by IntelliJ IDEA.
  User: Raoul
  Date: 14/01/2018
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.cps3222.*" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Request Key Page</title>
</head>
    <body>
        <form action="RequestLoginServlet" method="GET">
            ID: <input type="text" name="idField">
            <br/><br/>

            <input type="submit" value="Request Login">
        </form>
    </body>
</html>