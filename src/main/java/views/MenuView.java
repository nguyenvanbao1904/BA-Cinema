/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.util.Scanner;

/**
 *
 * @author MSII
 */
public class MenuView {
    private final Scanner sc = new Scanner(System.in);

    public void displayWelcomeView() {
        System.out.println("==============Chao Mung Den Voi BA-Cinema==============");
    }
    
    public int displayMainClientView() throws NumberFormatException{
        System.out.println("1. Dat Ve Truc tuyen");
        System.out.println("2. Tra cuu thong tin ve");
        System.out.println("3. Tra cuu lich chieu");
        System.out.println("4. Tra cuu phim");
        System.out.println("5. Tra cuu thong tin tai khoan");
        System.out.println("0. Thoat");
        System.out.print("Nhap lua chon cua ban: ");
        return Integer.parseInt(sc.nextLine());
    }
    
    public int displayMainManagerView() throws NumberFormatException{
        System.out.println("1. Quan ly lich chieu");
        System.out.println("2. Quan ly thong tin phim");
        System.out.println("3. Quan ly thong tin khach hang");
        System.out.println("0. Thoat");
        System.out.print("Nhap lua chon cua ban: ");
        return Integer.parseInt(sc.nextLine());
    }
}
