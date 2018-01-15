package com.cps3222;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/RequestLoginServlet")
public class RequestLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public Agent agent =  new Agent();
    public MessagingSystem ms = new MessagingSystem();
    public Supervisor supervisor = new Supervisor() {
        public String getLoginKey(Agent agent) {
            if (agent.id.substring(0, 2) != "spy") {
                return "ABCDE12345";
            }
            return null;
        }
    };


    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        agent.id = request.getParameter("idField");
        /*
        for (Agent a : ms.agentList) {
            if (a.id == request.getParameter("idField"));
                agent = a;
        }*/

        ms.requestLogin(agent, supervisor);

        request.setAttribute("id", agent.id);
        request.setAttribute("loginkey", agent.loginKey);

        RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
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
