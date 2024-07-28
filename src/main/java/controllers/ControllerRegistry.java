/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author MSII
 */
public class ControllerRegistry {
    private final Map<String, ControllerInterface> controllers;

    public ControllerRegistry() {
        controllers = new HashMap<>();
    }

    public void register(String name, ControllerInterface controller){
        controllers.put(name, controller);
    }
    
    public ControllerInterface getController(String name){
        return controllers.get(name);
    }
}
