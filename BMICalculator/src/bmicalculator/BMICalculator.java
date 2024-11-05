/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bmicalculator;

import java.util.Scanner;

/**
 *
 * @author TUF GAMING
 */
public class BMICalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Loop until user exit
        while (true) {
            displayMenu();
            //Step 1: get choice from user
            int choice = inputOption();
            switch (choice) {
                //Step 2: Calculate as normal
                case 1:
                    calculate();
                    break;
                //Step 3: Calculate BMI
                case 2:
                    calculateBMI();
                    break;
                //Step 4: Exit program
                case 3:
                    return;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int inputOption() {
        Scanner sc = new Scanner(System.in);
        int choice;
        //Loop until input valid
        while (true) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                //Check choice smaller than 1 or greater than 3
                if (choice < 1 || choice > 3) {
                    System.out.println("Choice is invalid. Please select option 1-3:");
                } else {
                    return choice;
                }
            } catch (Exception e) {
                System.out.println("Choice is invalid. Please select option 1-3:");
            }
        }
    }

    //allow user input number double
    public static double checkInputDouble() {
        Scanner sc = new Scanner(System.in);
        //loop until user input valid
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must be input double");
                System.out.print("Enter again: ");
            }
        }
    }

    private static double calculate() {
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter the first number: ");
    double result = checkInputDouble();  // Start with the first number as the initial result.
    
    while (true) {
        System.out.print("Enter an operator (+, -, *, /) or '=' to get the result: ");
        String input = sc.nextLine();
        
        // Check if the user entered '=' to end the calculation
        if (input.equals("=")) {
            System.out.println("Final result: " + result);
            return result;
        }
        
        // Validate operator input
        char operator = input.charAt(0);
        if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
            System.out.println("Invalid operator! Please enter a valid operator (+, -, *, /) or '='.");
            continue;
        }
        
        // Get the next number
        System.out.print("Enter the next number: ");
        double nextNumber = checkInputDouble();
        
        // Apply the operation
        switch (operator) {
            case '+':
                result += nextNumber;
                break;
            case '-':
                result -= nextNumber;
                break;
            case '*':
                result *= nextNumber;
                break;
            case '/':
                if (nextNumber != 0) {
                    result /= nextNumber;
                } else {
                    System.out.println("Cannot divide by zero! Ignoring this operation.");
                }
                break;
        }
        
        // Display the intermediate result
        System.out.println("Current result: " + result);
    }
}

    private static double calculateBMI() {
        System.out.print("Enter your weight (kg): ");
        double weight = checkInputDouble();

        System.out.print("Enter your height (m): ");
        double height = checkInputDouble();

        // BMI formula: weight (kg) / (height * height) (m^2)
        double bmi = weight / (height * height);
        System.out.println("Your BMI: " + bmi);
        System.out.println("BMI Status: " + BMIStatus(bmi));

        return bmi;
    }

    //display result BMI status
    public static String BMIStatus(double bmi) {
        if (bmi < 19) {
            return "Under-standard.";
        } else if (bmi >= 19 && bmi < 25) {
            return "Standard.";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight.";
        } else if (bmi >= 30 && bmi < 40) {
            return "Fat-should lose weight";
        } else {
            return "Very fat - should lose weight immediately";
        }
    }

}
