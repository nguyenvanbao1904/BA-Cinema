/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import controllers.AccountController;
import controllers.ClientController;
import controllers.ControllerRegistry;
import controllers.ShowtimesController;
import models.Account;
import models.AccountType;
import models.Showtimes;
import views.AccountView;
import views.MenuView;
import views.ShowtimesView;

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
            
            if(accountController.getAccountType() == AccountType.CLIENT){
                ControllerRegistry controllers = new ControllerRegistry();
                controllers.register(ShowtimesController.class.getSimpleName(), new ShowtimesController(new Showtimes(), new ShowtimesView()));
                ClientController clientController = new ClientController(controllers, menuView);
                clientController.run();
            }else if(accountController.getAccountType() == AccountType.MANAGER){
                menuView.displayMainManagerView();
            }
            
        }catch(NumberFormatException NFE){
            System.out.println("Khong hop le!\n " + NFE.getMessage());
        }
    }
}
