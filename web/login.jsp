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
    <title>Agent Login Page</title>
</head>
    <body>

        Your login key is: ${loginkey}
        <form action="LoginServlet">
            ID: <input type="text" name="idField" value=${id}>
            <br/><br/>

            Login key: <input type="text" name="loginKeyField">
            <br/><br/>

            <input type="submit" onclick="" value="Login">
        </form>
    </body>
</html>