package com.cps3222;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public RequestDispatcher rd;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String returnMessage = Main.ms.login(Main.agent, request.getParameter("loginKeyField"));

        ArrayList<Message> messages = new ArrayList<Message>();
        Main.mailbox = Main.agent.mailbox;
        for(Message m : Main.mailbox.mailboxQueue){
            messages.add(m);
        }

        request.setAttribute("messages", messages);
        request.setAttribute("loginReturnMessage", returnMessage);

        if(returnMessage != "Login Successful") {
            rd = request.getRequestDispatcher("/loginerror.jsp");
            rd.forward(request, response);
        }
        else {
            rd = request.getRequestDispatcher("/mailbox.jsp");
            rd.forward(request, response);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
