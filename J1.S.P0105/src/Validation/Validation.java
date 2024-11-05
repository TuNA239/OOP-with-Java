/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validation;

import java.util.Scanner;

/**
 *
 * @author TUF GAMING
 */
public class Validation {

    public static int getChoice(String msg, String errorMsg) {
        Scanner sc = new Scanner(System.in);
        //Loop until input is valid
        while (true) {
            System.out.print(msg);
            try {
                int choice = Integer.parseInt(sc.nextLine());
                //Check choice is 1-5
                if (choice >= 1 && choice <= 5) {
                    return choice;
                } else {
                    System.out.println(errorMsg);
                }
            } catch (NumberFormatException e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static String getName(String msg, String errorMsg) {
        Scanner sc = new Scanner(System.in);
        String regexName = "[A-Za-z ]+";
        //Loop until input is valid
        while (true) {
            System.out.print(msg);
            String name = sc.nextLine();
            //Check name is match with regex
            if (name.matches(regexName)) {
                return name;
            } else {
                System.out.println(errorMsg);
            }
        }
    }

    public static double checkDouble(String msg, String errorMsg) {
        Scanner sc = new Scanner(System.in);
        //Loop until input is valid
        while (true) {
            System.out.print(msg);
            try {
                double input = Double.parseDouble(sc.nextLine());
                //Check input is positive
                if (input > 0) {
                    return input;
                } else {
                    System.out.println(errorMsg);
                }

            } catch (NumberFormatException e) {
                System.out.println(errorMsg);
            }
        }
    }
    
    public static int checkInputId(String msg, String errorMsg){
        Scanner sc = new Scanner(System.in);
        //Loop until input is valid
        while(true){
            System.out.print(msg);
            try{
                int input = Integer.parseInt(sc.nextLine());
                return input;
            }catch(NumberFormatException e){
                System.out.println(errorMsg);
            }
        }
    }
    
    public static boolean checkInputYesNo(String msg, String errorMsg){
        Scanner sc = new Scanner(System.in);
        //Loop until input is valid
        while(true){
            System.out.print(msg);
            String input = sc.nextLine();
            //Check input is Y or y
            if(input.contentEquals("Y") || input.contentEquals("y")){
                return true;
            }
            //Check input is N or n
            else if(input.contentEquals("N") || input.contentEquals("n")){
                return false;
            }else{
                System.out.println(errorMsg);
            }
        }
    }
}
