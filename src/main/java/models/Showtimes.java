/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 *
 * @author MSII
 */
@Entity
public class Showtimes implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "showtime_id")
    private int id;
    @Column(unique = true)
    private String code;
    @Column(nullable = false)
    private String room;
    @Column(nullable = false)
    private String theater;
    @Column(nullable = false)
    private LocalDateTime dateTime;
    @Column(nullable = false)
    private int seats;
    @ManyToOne()
    @JoinColumn(name = "movie")
    private Movie movie;
    @OneToMany(mappedBy = "showtime")
    private Set<Ticket> tickets;
    private boolean isExpired;

    public Showtimes() {
    }

    public boolean isIsExpired() {
        return isExpired;
    }

    public void setIsExpired(boolean isExpired) {
        this.isExpired = isExpired;
    }

    public Showtimes(String code, String room, String theater, LocalDateTime dateTime, Movie movie, int seats) {
        this.code = code;
        this.room = room;
        this.theater = theater;
        this.dateTime = dateTime;
        this.movie = movie;
        this.seats = seats;
        this.isExpired = dateTime.isBefore(LocalDateTime.now());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getTheater() {
        return theater;
    }

    public void setTheater(String theater) {
        this.theater = theater;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    
     public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
