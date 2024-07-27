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
public class MenuController implements ControllerInterface{
    private ControllerRegistry controlers;
    private MenuView menuView;

    public MenuController(ControllerRegistry controlers, MenuView menuView) {
        this.controlers = controlers;
        this.menuView = menuView;
    }
    
    public void showMenu(){
        menuView.displayWelcomeView();
    }
}
