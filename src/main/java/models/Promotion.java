/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 *
 * @author MSII
 */
@Entity
public class Promotion implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "promotion_id")
    private int id;
    @Column(unique = true, nullable = false)
    private String code;
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "customer_type", nullable = false)
    private CustomerType customerType;
    @Column(name = "start_day")
    private LocalDateTime startDay;
    @Column(name = "end_day")
    private LocalDateTime endDay;
    @ManyToMany()
    @JoinTable(name = "customer_promotion",
            joinColumns = @JoinColumn(name = "promotion_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private Set<Customer> customers;

    public Promotion() {
    }

    public Promotion(String code, String description, CustomerType customerType, LocalDateTime startDay, LocalDateTime endDay) {
        this.code = code;
        this.description = description;
        this.customerType = customerType;
        this.startDay = startDay;
        this.endDay = endDay;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public LocalDateTime getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalDateTime startDay) {
        this.startDay = startDay;
    }

    public LocalDateTime getEndDay() {
        return endDay;
    }

    public void setEndDay(LocalDateTime endDay) {
        this.endDay = endDay;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
    
    
}
