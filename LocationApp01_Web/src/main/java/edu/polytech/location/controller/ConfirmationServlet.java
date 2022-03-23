package edu.polytech.location.controller;

import edu.polytech.location.business.BusinessLocal;
import edu.polytech.location.model.ReservationBean;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/confirmationServlet")
public class ConfirmationServlet extends HttpServlet {
    @EJB
    private BusinessLocal business;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ReservationBean reservation = new ReservationBean();

        business.insertReservation(reservation);
    }

}
