
import Model.Rectangle;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author TUF GAMING
 */
public class Validator {
    public static double InputPositiveNumber(){
        Scanner sc = new Scanner(System.in);
        double num;
        
        //Loop until user input positive number
        while(true){
            try{
                num = Double.parseDouble(sc.nextLine());
                //Check positive number
                if(num > 0){
                    break;
                }else{
                    System.out.println("Input is invalid. Please input a positive number!!");
                }
            } catch(NumberFormatException e){
                System.out.println("Input is invalid. Please enter a positive number!!");
            }
        }
        return num;
    }
    
    public static Rectangle InputRectangle(){
        double width;
        double length;
        
        //Loop until input is valid
        while(true){
            System.out.println("Enter side width of Rectangle:");
            width = InputPositiveNumber();
            System.out.println("Enter length of Rectangle:");
            length = InputPositiveNumber();
            
            //Check length is greater than width
            if(length > width){
                break;
            }else{
                System.out.println("Length must be greater than Width.");
            }
        }
        return new Rectangle(width, length);
    }
}
