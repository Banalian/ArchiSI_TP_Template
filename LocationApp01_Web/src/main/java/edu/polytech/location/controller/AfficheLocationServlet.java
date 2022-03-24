package edu.polytech.location.controller;

import edu.polytech.location.business.BusinessLocal;
import edu.polytech.location.model.LocationBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "afficheLocationServlet", value = "/afficheLocationServlet")
public class AfficheLocationServlet extends HttpServlet {

    @EJB
    private BusinessLocal business;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LocationBean locationBean = business.getLocation(Integer.valueOf(request.getParameter("id")));

        request.setAttribute("LOCATION", locationBean);

        request.getRequestDispatcher("afficheLocation.jsp").forward(request, response);
    }
}
