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
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author MSII
 */
@Entity
public class Ticket implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private int id;
    @Column(unique = true, nullable = false)
    private String code;
    @Column(nullable = false)
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "showtime")
    private Showtimes showtime;
    
    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;

    public Ticket() {
    }

    public Ticket(String code, BigDecimal price, Showtimes showtime) {
        this.code = code;
        this.price = price;
        this.showtime = showtime;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Showtimes getShowtime() {
        return showtime;
    }

    public void setShowtime(Showtimes showtime) {
        this.showtime = showtime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
}
