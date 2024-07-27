/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import controllers.AccountController;
import models.Account;
import models.AccountType;
import views.AccountView;
import views.MenuView;

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
                menuView.displayMainClientView();
            }else if(accountController.getAccountType() == AccountType.MANAGER){
                System.out.println("Chua hoan thien");
            }
        }catch(NumberFormatException NFE){
            System.out.println("Khong hop le!\n " + NFE.getMessage());
        }
    }
}
