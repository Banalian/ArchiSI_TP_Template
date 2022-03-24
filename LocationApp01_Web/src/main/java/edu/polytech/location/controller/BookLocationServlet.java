package edu.polytech.location.controller;

import edu.polytech.location.business.BusinessImpl;
import edu.polytech.location.business.BusinessLocal;
import edu.polytech.location.dao.LocationDao;
import edu.polytech.location.model.LocationBean;
import edu.polytech.location.model.ReservationBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Servlet implementation class BookLocationServlet
 * Gathers the information of the reservation and send it to the business layer to compute the price, then send it to the view for confirmation by the user
 */
@WebServlet(name = "bookLocationServlet", value = "/bookLocationServlet")
public class BookLocationServlet extends HttpServlet {

    @EJB
    private BusinessLocal business;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ReservationBean reservation = new ReservationBean();
        Date dateDebut = null;
        Date dateFin = null;
        boolean cleaning = false;
        boolean insurance = false;

        String dateDebutS = request.getParameter("startDate");

        try {
            dateDebut = new SimpleDateFormat("yyyy-MM-dd").parse(dateDebutS);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String dateFinS = request.getParameter("endDate");

        try {
            dateFin = new SimpleDateFormat("yyyy-MM-dd").parse(dateFinS);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        LocationBean locationBean = business.getLocation(Integer.valueOf(request.getParameter("id")));

        if(request.getParameter("cancelInsurance")!=null && request.getParameter("cancelInsurance").equals("on")){
            insurance = true;
        }
        if(request.getParameter("cleaning")!=null && request.getParameter("cleaning").equals("on")) {
            cleaning = true;
        }

        reservation = business.computeReservation(locationBean, dateDebut,dateFin,insurance, cleaning);

        request.setAttribute("RESERVATION",reservation);

        request.getRequestDispatcher("bookLocation.jsp").forward(request,response);
    }

}
