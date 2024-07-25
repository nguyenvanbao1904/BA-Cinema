/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import org.hibernate.Session;
import hibernateUtils.HibernateUtils;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import models.Account;
import models.AccountType;
import models.Movie;
import models.Showtimes;

/**
 *
 * @author MSII
 */
public class Main {

    public static void main(String[] args) {
        Session session = HibernateUtils.getFactory().openSession();
        session.getTransaction().begin();
//        List<String> genre = new ArrayList<>();
//        genre.add("Hai");
//        genre.add("Hoat Hinh");
//        List<String> director = new ArrayList<>();
//        director.add("Nguyen Van Binh");
//        director.add("Duong Thi Thanh Ngan");
//        List<String> cast = new ArrayList<>();
//        cast.add("Nguyen Thi Bao Ngoc");
//        cast.add("Vu Hoang Phuong Anh");
//        Movie doraemon = new Movie("doraemon32", "Doraemon va Nobita", genre, director, cast);
//        session.persist(doraemon);
//        
//        Movie m = session.get(Movie.class, 1);
//        
//        List<Showtimes> l = m.getShowTimes();
//        l.forEach(e -> System.out.printf("%s - %s - %s\n", e.getRoom(), e.getTheater(), e.getDateTime().toString()));

        System.out.println("ok");

        session.getTransaction().commit();
        session.close();
    }
}
