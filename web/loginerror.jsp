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
    <title>ERROR</title>
</head>
    <body>

        <h3 name="errorMessage">${loginReturnMessage}</h3>

        <form action="IndexRedirectServlet" method="GET">
            <input type="submit" value="Back to Index Page">
        </form>
    </body>
</html>