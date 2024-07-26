/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

/**
 *
 * @author MSII
 */
public class MenuView {

    public static void displayWelcomeView() {
        System.out.println("==============Chao Mung Den Voi BA-Cinema==============");
    }
    
    public static void displayMainClientView(){
        System.out.println("1. Dat Ve Truc tuyen");
        System.out.println("2. Tra cuu thong tin ve");
        System.out.println("3. Tra cuu lich chieu");
        System.out.println("4. Tra cuu phim");
        System.out.println("5. Tra cuu thong tin tai khoan");
        System.out.println("0. Thoat");
    }
    
    public static void displayMainManagerView(){
        System.out.println("1. Quan ly lich chieu");
        System.out.println("2. Quan ly thong tin phim");
        System.out.println("3. Quan ly thong tin khach hang");
    }

}
