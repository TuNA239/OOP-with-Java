/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Storekeeper;
import Validation.Validation;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TUF GAMING
 */
public class Controller {

    public static List<Storekeeper> addStrorekeeper() {
        Validation v = new Validation();
        List<Storekeeper> ls = new ArrayList<>();
        boolean flag = true;

        //Loop until user exit
        while (flag) {
            int id = v.checkInputId("Enter Storekeeper ID: ", "Id is invalid. Please enter again!!");
            String name = v.getName("Enter Storekeeper Name: ", "Name is invalid. Please enter again!!");
            boolean checkName = true;
            //Loop through each element of list
            for (Storekeeper l : ls) {
                //Check name is match
                if (l.getId() == id) {
                    System.out.println("Id is already existed!!");
                    checkName = false;
                    break;
                }
            }

            //Check checkname is true
            if (checkName) {
                Storekeeper st = new Storekeeper(name, id);
                ls.add(st);
            }

            flag = v.checkInputYesNo("Do you want to enter more? (Y/N) ", "Input is invalid. Please enter Y/y or N/n !!!");
        }
        return ls;
    }
}
