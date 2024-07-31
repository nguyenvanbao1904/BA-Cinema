/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import models.Ticket;
import org.hibernate.Session;
import views.TicketView;
import hibernateUtils.HibernateUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

/**
 *
 * @author MSII
 */
public class TicketController implements ControllerInterface {
    private Ticket model;
    private TicketView view;

    public TicketController(Ticket model, TicketView view) {
        this.model = model;
        this.view = view;
    }
    
    public void showAllTicket(){
        try(Session session = HibernateUtils.getFactory().openSession()){
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Ticket> query = builder.createQuery(Ticket.class);
            Root<Ticket> root = query.from(Ticket.class);
            query.where(builder.equal(root.get("showtime").get("isExpired"), false));
            List<Ticket> listTicket = session.createQuery(query).getResultList();
            view.showAllTicket(listTicket);
        }
    }
    
    public void bookTicket(){
        
    }
}
