/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import controllers.ShowtimesController;
import hibernateUtils.HibernateUtils;
import java.time.LocalDateTime;
import models.Movie;
import models.Showtimes;
import org.hibernate.Session;


/**
 *
 * @author MSII
 */
public class Test {
    public static void main(String[] args) {
        Session session = HibernateUtils.getFactory().openSession();
        session.getTransaction().begin();
        ShowtimesController c = new ShowtimesController(new Showtimes(), new views.ShowtimesView());
        c.updateOldShowtimes();
        session.getTransaction().commit();
        session.close();
    
    }
}
