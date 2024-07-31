/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import views.MenuView;

/**
 *
 * @author MSII
 */
public class ClientController implements ControllerInterface{
    private final ControllerRegistry controllers;
    private final MenuView menuView;

    public ClientController(ControllerRegistry controllers, MenuView menuView) {
        this.controllers = controllers;
        this.menuView = menuView;
    }
    
    public void run(){
        
        int choice;
        do {            
            choice = menuView.displayMainClientView();
            switch (choice) {
                case 0 -> System.out.println("Bye");
                case 1 -> {
                    TicketController ticketController = (TicketController)controllers.getController(TicketController.class.getSimpleName());
                    if(ticketController != null){
                        ((ShowtimesController)controllers.getController(ShowtimesController.class.getSimpleName())).updateOldShowtimes();
                        ticketController.showAllTicket(); 
                        ticketController.bookTicket();
                    }
                }
                case 3 -> {
                    ShowtimesController showTimescontroller = (ShowtimesController)controllers.getController(ShowtimesController.class.getSimpleName());
                    if(showTimescontroller != null){
                        showTimescontroller.updateOldShowtimes();
                        showTimescontroller.getAllShowTimes();
                    }
                }
                default -> System.out.println("Lua chon khong hop le");
            }
        } while (choice != 0);
    }
}
