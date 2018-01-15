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
@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public RequestDispatcher rd;
    public String messageResponse;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameter("sendButton") != null){

            for(Agent targetAgent : Main.ms.agentList){
                if(targetAgent.id.equals(request.getParameter("idField"))){

                    for(Agent sourceAgent : Main.ms.agentList){
                        if(sourceAgent.id.equals(request.getParameter("id"))){
                            messageResponse = Main.ms.sendMessage(sourceAgent, targetAgent, request.getParameter("msgField"));

                            request.setAttribute("messageResponse", messageResponse);
                        }
                    }
                }
            }

            request.setAttribute("id", request.getParameter("id"));
            rd = request.getRequestDispatcher("/messageresponse.jsp");
            rd.forward(request, response);
        }
        else{
            rd = request.getRequestDispatcher("/index.jsp");
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
