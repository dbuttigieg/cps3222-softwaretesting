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
    public Agent currAgent;

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

        String agentId = request.getParameter("idField");
        String agentName = request.getParameter("nameField");

        /*
        for (Agent a : ms.agentList) {
            if (a.id == request.getParameter("idField"));
                agent = a;
        }*/

        Main.ms.requestLogin(new Agent(agentId, agentName), Main.supervisor);

        for(Agent a : Main.ms.agentList){
            if(a.id.equals(agentId)) {
                request.setAttribute("id", agentId);
                request.setAttribute("name", agentName);
                request.setAttribute("loginkey", a.loginKey);
            }
        }

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
