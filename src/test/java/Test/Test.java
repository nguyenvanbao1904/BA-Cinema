/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import hibernateUtils.HibernateUtils;
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
        Showtimes showtimes = session.get(Showtimes.class, 6);
        showtimes.setSeats(70);
        showtimes.setSelectedSeats(23);
        session.getTransaction().commit();
        session.close();
    
    }
}
