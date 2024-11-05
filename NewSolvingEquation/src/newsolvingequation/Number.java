/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newsolvingequation;

/**
 *
 * @author TUF GAMING
 */
public class Number {
    public Number(){
        
    }
    
    public float checkin(String floatString){
        try{
            float result = Float.parseFloat(floatString);
            return 1;
        }catch(NumberFormatException e){
            System.out.println("Please input number");
        }
        return 0;
    }
    
    public boolean isOdd(float number){
        return number % 2 != 0;
    }
    
    public boolean isPerfectSquare(float number){
        //Check number is negative
        if(number < 0){
            return false;
        }
        double squareRoot = Math.sqrt(number);
        return squareRoot == Math.floor(squareRoot);
    }
}
