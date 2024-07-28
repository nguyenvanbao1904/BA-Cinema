/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import hibernateUtils.HibernateUtils;
import java.time.LocalDateTime;
import java.util.List;
import models.Showtimes;
import org.hibernate.Session;
import views.ShowtimesView;

/**
 *
 * @author MSII
 */
public class ShowtimesController implements ControllerInterface{
    private Showtimes model;
    private ShowtimesView view;

    public ShowtimesController(Showtimes model, ShowtimesView view) {
        this.model = model;
        this.view = view;
    }
    
    public void getAllShowTimes(){
        try(Session session = HibernateUtils.getFactory().openSession()){
            List<Showtimes> showtimes = session.createQuery("from Showtimes where dateTime >= :currentDate", Showtimes.class).setParameter("currentDate", LocalDateTime.now()).getResultList();
            view.showAll(showtimes);
        }
    }
}
