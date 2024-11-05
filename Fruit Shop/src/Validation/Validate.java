/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validation;

import Model.Fruit;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author TUF GAMING
 */
public class Validate {

    public int getPositiveInteger(String msg, String errMsg) {
        Scanner sc = new Scanner(System.in);
        //Loop until input is valid
        while (true) {
            try {
                System.out.print(msg);
                int input = Integer.parseInt(sc.nextLine());
                //Check number is not positive
                if (input <= 0) {
                    System.out.println(errMsg);
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println(errMsg);
            }
        }
    }

    public String getInputString(String msg, String errMsg) {
        Scanner sc = new Scanner(System.in);
        String regex = "[A-Za-z ]+";
        //Loop until input is valid
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine();
            //Check input is match with regex
            if (input.matches(regex)) {
                return input;
            } else {
                System.out.println(errMsg);
            }
        }
    }

    public double getPositiveDouble(String msg, String errMsg) {
        Scanner sc = new Scanner(System.in);
        //Loop until input is valid
        while (true) {
            try {
                System.out.print(msg);
                double input = Double.parseDouble(sc.nextLine());
                //Check number is not positive
                if (input <= 0) {
                    System.out.println(errMsg);
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println(errMsg);
            }
        }
    }

    public boolean checkInputYesNo(String msg) {
        Scanner sc = new Scanner(System.in);

        //Loop until input is valid
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine();
            //Check input is Y or y
            if (input.trim().contentEquals("Y") || input.trim().contentEquals("y")) {
                return true;
            } //Check input is N or n
            else if (input.trim().contentEquals("N") || input.trim().contentEquals("n")) {
                return false;
            } else {
                System.out.println("Input is invalid. Please enter Y/y or N/n");
            }
        }
    }

    public int inputFruitId(List<Fruit> listFruit) {
        Scanner sc = new Scanner(System.in);

        //Loop until input is valid
        while (true) {
            System.out.print("Enter fruit ID: ");
            boolean isExisted = false;
            try {
                int input = Integer.parseInt(sc.nextLine());
                //Check input is not positvive
                if (input <= 0) {
                    System.out.println("ID is invalid. Please enter a positive integer!!");
                } else {
                    //Loop through each element of list fruit
                    for (Fruit f : listFruit) {
                        //Check id is duplicate
                        if (input == f.getId()) {
                            isExisted = true;
                            System.out.println("ID is existed. Please enter another ID!!");
                            break;
                        }
                    }
                    //Check isExisted is false
                    if (!isExisted) {
                        return input;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Input is invalid. Please enter a positive integer!!");
            }
        }
    }

    public Fruit getFruitByIndex(List<Fruit> listFruit) {
        Scanner sc = new Scanner(System.in);

        //Loop until input is valid
        while (true) {
            try {
                System.out.print("Select fruit: ");
                int input = Integer.parseInt(sc.nextLine());
                //Check input is exist
                if (input < 1 || input > listFruit.size()) {
                    System.out.println("Item is invalid. Please select an existing item!!");
                } else {
                    Fruit f = listFruit.get(input - 1);
                    return f;
                }
            } catch (NumberFormatException e) {
                System.out.println("Item is invalid. Please select an existing item!!");
            }
        }
    }
    
    public int getQuantityItemOrdered(Fruit f){
        //Loop until input is  valid
        while(true){
            int quantity = getPositiveInteger("Please input quantity: ", "Input is invalid. Please enter a positive integer!!");
            //Check quantity is less or equal to quantity in stock
            if(quantity > f.getQuantity()){
                System.out.println("Item in stock is not enough!!!");
                System.out.println("Current quantity in stock: " + f.getQuantity());
            }else{
                f.setQuantity(f.getQuantity() - quantity);
                return quantity;
            }
        }
    }
}
