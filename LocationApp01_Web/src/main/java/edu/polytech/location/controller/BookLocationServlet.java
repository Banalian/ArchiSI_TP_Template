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

@WebServlet("/bookLocationServlet")
public class BookLocationServlet extends HttpServlet {

    @EJB
    private BusinessLocal business;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ReservationBean reservation = new ReservationBean();

        String dateDebutS = request.getParameter("startDate");
        Date dateDebut = null;
        try {
            dateDebut = new SimpleDateFormat("yyyy/MM/dd").parse(dateDebutS);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String dateFinS = request.getParameter("endDate");
        Date dateFin = null;
        try {
            dateFin = new SimpleDateFormat("yyyy/MM/dd").parse(dateFinS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int dureeEnJour = 0;

        try {
            dureeEnJour = (int) TimeUnit.DAYS.convert(dateFin.getTime() - dateDebut.getTime(), TimeUnit.MILLISECONDS);
        }
        catch(NullPointerException e){
            e.printStackTrace();
        }
        LocationBean locationBean = business.getLocation(Integer.valueOf(request.getParameter("id")));

        reservation.setPrixLocation(reservation.getDureeEnJours()*reservation.getPrixLocation());
        reservation.setAppart(locationBean);
        reservation.setDateDebut(dateDebut);
        reservation.setDateFin(dateFin);
        reservation.setDureeEnJours(dureeEnJour);
        reservation.setPrixAssurance(reservation.getPrixLocation()*(float)0.05);
        reservation.setPrixMenage(20);

        if(request.getParameter("cancelInsurance")!=null && request.getParameter("cancelInsurance").equals("on")){
            reservation.setAssurance(true);
        }
        if(request.getParameter("cleaning")!=null && request.getParameter("cleaning").equals("on")) {
            reservation.setMenage(true);
        }

        request.setAttribute("RESERVATION",reservation);

        request.getRequestDispatcher("bookLocation.jsp").forward(request,response);
    }

}
