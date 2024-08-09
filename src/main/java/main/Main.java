/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import controllers.AccountController;
import controllers.ClientController;
import controllers.ControllerRegistry;
import controllers.ShowtimesController;
import controllers.TicketController;
import models.Account;
import models.AccountType;
import models.Customer;
import models.Showtimes;
import models.Ticket;
import org.hibernate.Session;
import views.AccountView;
import views.MenuView;
import views.ShowtimesView;
import views.TicketView;

/**
 *
 * @author MSII
 */
public class Main {

    public static void main(String[] args) {
        MenuView menuView = new MenuView();
        menuView.displayWelcomeView();
        
        try{
            AccountView accountView = new AccountView();
            Account accountModel = new Account();
            AccountController accountController = new AccountController(accountModel, accountView);
            
            ControllerRegistry controllers = new ControllerRegistry();
            controllers.register(ShowtimesController.class.getSimpleName(), new ShowtimesController(new Showtimes(), new ShowtimesView()));
            controllers.register(TicketController.class.getSimpleName(), new TicketController(new Ticket(), new TicketView()));
            if(accountController.getAccountType() == AccountType.CLIENT){
                ClientController clientController = new ClientController(controllers, menuView);
                clientController.run();
            }else if(accountController.getAccountType() == AccountType.MANAGER){
                menuView.displayMainManagerView();
            }
            
        }catch(NumberFormatException NFE){
            System.out.println("Khong hop le!\n " + NFE.getMessage());
        }
//        Session session = hibernateUtils.HibernateUtils.getFactory().openSession();
//        Customer customer = new Customer();
//        session.close();
    }
}
