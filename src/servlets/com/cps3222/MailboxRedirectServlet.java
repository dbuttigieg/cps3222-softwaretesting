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
@WebServlet("/MailboxRedirectServlet")
public class MailboxRedirectServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public RequestDispatcher rd;
    ArrayList<Message> messages = new ArrayList<Message>();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailboxRedirectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        for(Agent a : Main.ms.agentList){
            if(a.id.equals(request.getParameter("id"))) {
                if(System.currentTimeMillis() - a.loginTime >= 600000){
                    request.setAttribute("messageResponse", "Session timeout");
                    rd = request.getRequestDispatcher("/index.jsp");
                    rd.forward(request, response);
                }
            }
        }

        for(Agent a : Main.ms.agentList){
            if(a.id.equals(request.getParameter("id")))
                for(Message m : a.mailbox.mailboxQueue){
                    messages.add(m);
                }

                request.setAttribute("messages", messages);
        }

        request.setAttribute("id", request.getParameter("id"));
        rd = request.getRequestDispatcher("/messagingsystem.jsp");
        rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
