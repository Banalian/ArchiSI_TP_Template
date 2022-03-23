package edu.polytech.location.controller;

import edu.polytech.location.business.BusinessLocal;
import edu.polytech.location.model.LocationBean;
import edu.polytech.location.model.ReservationBean;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@WebServlet("/confirmationServlet")
public class ConfirmationServlet extends HttpServlet {
    @EJB
    private BusinessLocal business;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ReservationBean reservation = new ReservationBean();
        LocationBean appart = business.getLocation(Integer.parseInt(request.getParameter("idAppart")));
        reservation.setAppart(appart);

        String dateDebutS = request.getParameter("dateDebut");
        Date dateDebut = null;
        try {
            dateDebut = new SimpleDateFormat("yyyy/MM/dd").parse(dateDebutS);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String dateFinS = request.getParameter("dateFin");
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

        reservation.setDateDebut(dateDebut);
        reservation.setDateFin(dateFin);
        reservation.setDureeEnJours(dureeEnJour);
        reservation.setPrixMenage(Float.parseFloat(request.getParameter("prixMenage")));
        reservation.setPrixLocation(Float.parseFloat(request.getParameter("prixLocation")));
        reservation.setPrixAssurance(Float.parseFloat(request.getParameter("prixAssurance")));
        reservation.setReducFidelite(Float.parseFloat(request.getParameter("reducFidelite")));
        reservation.setReducSejourLong(Float.parseFloat(request.getParameter("reducSejourLong")));
        reservation.setReducSup500(Float.parseFloat(request.getParameter("reducSup500")));
        reservation.setReducSejoutLointain(Float.parseFloat(request.getParameter("reducSejourLointain")));

        business.computePrice(reservation);

        business.insertReservation(reservation);

        request.setAttribute("RESERVATION",reservation);

        request.getRequestDispatcher("locationsList.jsp").forward(request,response);
    }

}
