/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package j1.l.p0023;

import Controller.Controller;
import View.View;

/**
 *
 * @author TUF GAMING
 */
public class J1LP0023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        controller.start();
    }

}
