package edu.polytech.location.controller;

import edu.polytech.location.business.BusinessLocal;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * Servlet implementation class ConnexionServlet
 * checks if the user is correct, and redirects to the location list page
 */
@WebServlet(name = "connexionServlet", value = "/connexionServlet")
public class ConnexionServlet extends HttpServlet {

    @EJB
    private BusinessLocal business;

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        if (login.equals("42")) {
            request.setAttribute("LOCATIONS_LIST", business.getLocations());
            //on imagine que on va garder en plus dans un cookie le login
            request.getRequestDispatcher("locationsList.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("accueil.jsp").forward(request, response);
        }
    }


}
