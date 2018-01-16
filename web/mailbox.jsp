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
    <title>Mailbox</title>
</head>
    <body>
    <h3>${returnMessage}</h3>
            Mail:
        <form action="ConsumeMessageServlet" method="GET">
            <input type="text" name="id" value="${id}" hidden>

            <input type="submit" name="consumeMessageButton" value="Get Next Message">

            <p name="messageText">${noMessages}<br/>
                ${messageFrom}<br/>
                ${messageContent}<br/></p>
            <br/><br/>
            <input type="submit" name="returnToSystemButton" value="Back to Messaging System">
        </form>
    </body>
</html>