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
    <title>Message Response</title>
</head>
    <body>

        <input type="text" name="id" hidden>

        <h3>${messageResponse}</h3>

        <form action="MailboxRedirectServlet" method="GET">
            <input type="submit" value="Back to Mailbox"  name="backToMailboxButton">
        </form>
    </body>
</html>