/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package View;

import Controller.Controller;
import Model.Storekeeper;
import Validation.Validation;
import java.util.List;

/**
 *
 * @author TUF GAMING
 */
public class J1SP0105 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Validation v = new Validation();
        Controller c = new Controller();
        
        System.out.println("======Product Management System======");
        //Step 1: Display menu
        displayMenu();
        //Step 2: Get choice from user 
        int choice = v.getChoice("Please select options 1-5: ","Choice is invalid. Please select options 1-5!!");
        
        switch(choice){
            //Step 3: Add storekeeper
            case 1:
                List<Storekeeper> ls = c.addStrorekeeper();
                break;
            //Step 4: Add product
            case 2:
//                addProduct();
                break;
            //Step 5: Update product
            case 3:
//                updateProduct();
                break;
            //Step 6: Search product
            case 4:
//                searchProduct();
                break;
            //Step 7: Sort product
            case 5:
//                sortProduct();
                break;
        }
    }

    private static void displayMenu() {
        System.out.println("1. Add Storekeeper");
        System.out.println("2. Add Product");
        System.out.println("3. Update product");
        System.out.println("4. Search product");
        System.out.println("5. Sort product");
    }

}
