/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hibernateUtils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author MSII
 */
public class HibernateUtils {
    private static final SessionFactory factory;
    
    static{
        factory = new Configuration().configure("hibernateConfig/hibernate.cfg.xml").buildSessionFactory();
    }

    public static SessionFactory getFactory() {
        return factory;
    }
}
