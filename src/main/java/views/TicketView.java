/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.util.List;
import models.Ticket;

/**
 *
 * @author MSII
 */
public class TicketView {
    public void showAllTicket(List<Ticket> tickets){
        tickets.forEach(e -> System.out.printf("Ma ve: %s - Phim: %s - Gia: %s - So ve con lai: %d\n",
                e.getCode(),
                e.getShowtime().getMovie().getName(),
                e.getPrice().toPlainString(),
                e.getShowtime().getSeats() - e.getNumOfTicketBooked()));
    }
    
    public Ticket getBookingTicketInfo(){
        return new Ticket();
    }
}
