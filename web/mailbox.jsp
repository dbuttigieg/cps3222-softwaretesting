<%@ page import="com.cps3222.Message" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Raoul
  Date: 15/01/2018
  Time: 00:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your Mailbox</title>
    <h3>${loginReturnMessage}</h3>
    <br/><br/>
    ${messageSuccess}
    Mail:
    <br/>
    <%
        // retrieve messages from the request
        ArrayList<Message> list = (ArrayList<Message>) request.getAttribute("messages");

        // print the information about every category of the list
        for(Message m : list) {
            out.println("From: " + m.sourceAgent.name);
            out.println("Date: " + m.timestamp);
            out.println("Message: " + m.content);
            out.println("<br/>");
        }
    %>
    <br/><br/>
    <form action="MessageServlet" method="GET">
        Target Agent ID: <input type="text" name="idField">
        <br/><br/>

        Send Message: <input type="text" name="msgField">
        <br/>

        <input type="submit" value="Send">
    </form>
</head>
<body>

</body>
</html>
