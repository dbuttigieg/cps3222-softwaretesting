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
@WebServlet("/MailboxServlet")
public class MailboxServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public RequestDispatcher rd;
    public String mailboxReturnMessage;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailboxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        for(Agent a : Main.ms.agentList){
            if(a.id.equals(request.getParameter("id"))) {
                if(a.mailbox.hasMessages(a.mailbox.mailboxQueue) == true) {
                    mailboxReturnMessage = "You've got mail!";
                }
                else
                    mailboxReturnMessage = "No mail.";
            }
        }

        request.setAttribute("returnMessage", mailboxReturnMessage);
        request.setAttribute("id", request.getParameter("id"));

        rd = request.getRequestDispatcher("/mailbox.jsp");
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