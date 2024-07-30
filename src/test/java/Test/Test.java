/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

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
        session.getTransaction().commit();
        session.close();
    
    }
}
