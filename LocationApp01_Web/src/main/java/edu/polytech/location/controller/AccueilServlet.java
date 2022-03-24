package edu.polytech.location.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * Servlet implementation class AccueilServlet
 * Home page of the application, redirect to the login page
 */
@WebServlet(name = "accueilServlet", value = "/accueilServlet")
public class AccueilServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("accueil.jsp").forward(request, response);
    }

}
