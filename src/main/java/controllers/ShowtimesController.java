/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import hibernateUtils.HibernateUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.List;
import models.Showtimes;
import org.hibernate.Session;
import views.ShowtimesView;

/**
 *
 * @author MSII
 */
public class ShowtimesController implements ControllerInterface {

    private Showtimes model;
    private final ShowtimesView view;

    public ShowtimesController(Showtimes model, ShowtimesView view) {
        this.model = model;
        this.view = view;
    }
    
    private void updateShowtimes(boolean isExpired){
        try(Session session = HibernateUtils.getFactory().openSession()){
            session.getTransaction().begin();
            try{
                CriteriaBuilder builder = session.getCriteriaBuilder();
                CriteriaUpdate<Showtimes> update = builder.createCriteriaUpdate(Showtimes.class);
                Root<Showtimes> root = update.from(Showtimes.class);
                Predicate p = isExpired ? builder.lessThan(root.get("dateTime"), LocalDateTime.now()): builder.greaterThan(root.get("dateTime"), LocalDateTime.now());
                update.set(root.get("isExpired"), isExpired).where(p);
                session.getTransaction().commit();
            }catch(Exception e){
                System.out.println(e.getMessage());
                session.getTransaction().rollback();
            }
        }
    }

    public void updateOldShowtimes() {
        updateShowtimes(true);
        updateShowtimes(false);
        
    }

    public void getAllShowTimes() {
        try (Session session = HibernateUtils.getFactory().openSession()) {
            List<Showtimes> showtimes = session.createQuery("from Showtimes where isExpired = :isExpired", Showtimes.class).setParameter("isExpired", false).getResultList();
            view.showAll(showtimes);
        }
    }
}
