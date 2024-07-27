/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.util.Scanner;
import models.Account;
import models.AccountType;

/**
 *
 * @author MSII
 */
public class AccountView {
    private final Scanner sc = new Scanner(System.in);
    
    public int displayClientMenuLoginView() throws NumberFormatException{
        System.out.println("===========Dang Nhap/Dang Ky===========");
        System.out.println("1. Dang Nhap");
        System.out.println("2. Dang Ky");
        System.out.println("0. Thoat");
        System.out.print("Nhap lua chon cua ban: ");
        return Integer.parseInt(sc.nextLine());
    }
    
    public Account getClientLoginInfoView(){
        System.out.print("User name: ");
        String userName = sc.nextLine().trim();
        System.out.print("Password: ");
        String password = sc.nextLine().trim();
        return new Account(userName, password, AccountType.CLIENT);
    }
    
    public Account getClientSignUpInfoView(){
        System.out.print("User name: ");
        String userName = sc.nextLine().trim();
        System.out.print("Password: ");
        String password = sc.nextLine().trim();
        String rePassword;
        do {            
            System.out.print("Re-enter password: ");
            rePassword = sc.nextLine().trim();
            if(!password.equals(rePassword)){
                System.out.println("Password khong khop! Thu lai");
            }
        } while (!password.equals(rePassword));
        return new Account(userName, password, AccountType.CLIENT);
    }
}
