/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package solvingequation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author TUF GAMING
 */
public class SolvingEquation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Loop until user exit
        while (true) {
            //Step 1: Display menu
            DisplayMenu();
            //Step 2: Select an option
            int choice = InputOption();
            switch (choice) {
                //Step 3: Calculate Superlative Equation
                case 1:
                    CalSuperlativeEquation();
                    break;
                // Step 4: Calculate Quadratic Equation
                case 2:
                    CalQuadraticEquation();
                    break;
                //Step 5: Exit
                case 3:
                    return;
            }
        }
    }

    private static void DisplayMenu() {
        System.out.println("========= Equation Program =========");
        System.out.println("1. Calculate Superlative Equation");
        System.out.println("2. Calculate Quadratic Equation");
        System.out.println("3. Exit");
        System.out.println("Please choice one option:");

    }

    private static int InputOption() {
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

    private static void CalSuperlativeEquation() {
        Number num = new Number();
        System.out.println("----- Calculate Equation -----");
        System.out.print("Enter A: ");
        float a = InputCoefficient();
        System.out.print("Enter B: ");
        float b = InputCoefficient();
        List<Float> solution = calculateEquation(a, b);
        List<Float> numbers = new ArrayList<>();
        List<Float> oddNumber = new ArrayList<>();
        List<Float> evenNumber = new ArrayList<>();
        List<Float> perfectSquareNumber = new ArrayList<>();
        numbers.add(a);
        numbers.add(b);
        //Check solution is not null and not empty
        if (solution != null && solution.isEmpty() == false) {
            numbers.addAll(solution);
        }

        //Check solution is null
        if (solution == null) {
            System.out.println("Solution: No solution");
        } //Check solution is empty
        else if (solution.isEmpty()) {
            System.out.println("Solution: Infinity solution");
        } else {
            System.out.printf("Solution: x = %.3f", solution.get(0));
            System.out.println("");
        }

        FindTypeOfNumber(numbers, oddNumber, evenNumber, perfectSquareNumber);

        System.out.print("Number is Odd:");
        DisplayListNumber(oddNumber);
        System.out.print("Number is Even:");
        DisplayListNumber(evenNumber);
        System.out.print("Number is Perfect Square:");
        DisplayListNumber(perfectSquareNumber);
    }

    private static void CalQuadraticEquation() {
        Number num = new Number();
        System.out.println("----- Calculate Quadratic Equation -----");
        System.out.print("Enter A: ");
        float a = InputCoefficient();
        System.out.print("Enter B: ");
        float b = InputCoefficient();
        System.out.print("Enter C: ");
        float c = InputCoefficient();
        List<Float> solution = calculateQuadraticEquation(a, b, c);
        List<Float> numbers = new ArrayList<>();
        List<Float> oddNumber = new ArrayList<>();
        List<Float> evenNumber = new ArrayList<>();
        List<Float> perfectSquareNumber = new ArrayList<>();
        numbers.add(a);
        numbers.add(b);
        numbers.add(c);
        //Check solution is not null and not empty
        if (solution != null && solution.isEmpty() == false) {
            numbers.addAll(solution);
        }

        //Check solution is null
        if (solution == null) {
            System.out.println("Solution: No solution");
        } //Check solution is empty
        else if (solution.isEmpty()) {
            System.out.println("Solution: Infinity solution");
        }
        //Check size of solution equal 1
        if (solution.size() == 1) {
            System.out.printf("Solution: x = %.3f", solution.get(0));
            System.out.println("");
        }
        //Check size of solution equal 2
        if (solution.size() == 2) {
            System.out.printf("Solution: x1 = %.3f and x2 = %.3f", solution.get(0), solution.get(1));
            System.out.println("");
        }

        FindTypeOfNumber(numbers, oddNumber, evenNumber, perfectSquareNumber);

        System.out.print("Odd Number(s):");
        DisplayListNumber(oddNumber);
        System.out.print("Number is Even:");
        DisplayListNumber(evenNumber);
        System.out.print("Number is Perfect Square:");
        DisplayListNumber(perfectSquareNumber);
    }

    private static float InputCoefficient() {
        Scanner sc = new Scanner(System.in);
        Number num = new Number();
        String input;
        //Loop until input is valid
        while (true) {
            input = sc.nextLine();
            float check = num.checkin(input);
            //Check is equal 1
            if (check == 1) {
                return Float.parseFloat(input);
            }
        }
    }

    public static List<Float> calculateEquation(float a, float b) {
        List<Float> solutions = new ArrayList<>();
        //Check is equal 0
        if (a == 0) {
            //Check is equal 0
            if (b == 0) {
            } else {
                return null;
            }
        } else {
            //Check b equal 0
            if (b == 0) {
                float solution = 0;
                solutions.add(solution);
            } else {
                float solution = -b / a;
                solutions.add(solution);
            }
        }

        return solutions;
    }

    public static List<Float> calculateQuadraticEquation(float a, float b, float c) {
        List<Float> solutions = new ArrayList<>();
        // Check is equal 0
        if (a == 0) {
            return calculateEquation(b, c);
        }

        float delta = b * b - 4 * a * c;

        // Check delta is grater than 0
        if (delta >= 0) {
            float root1 = (-b + (float) Math.sqrt(delta)) / (2 * a);
            float root2 = (-b - (float) Math.sqrt(delta)) / (2 * a);
            solutions.add(root1);
            solutions.add(root2);
        } else {
            return null;
        }

        return solutions;
    }

    public static void DisplayListNumber(List<Float> listNumber) {
        //Check list is not empty
        if (listNumber.isEmpty()) {
            System.out.println("No odd number");
        } else {
            //Loop from first element to last element of list
            for (int i = 0; i < listNumber.size(); i++) {
                //Check is last element of list
                if (i == listNumber.size() - 1) {
                    System.out.print(listNumber.get(i));
                    System.out.println("");
                } else {
                    System.out.print(listNumber.get(i) + ", ");
                }
            }
        }
    }

    public static void FindTypeOfNumber(List<Float> numbers, List<Float> oddNumber, List<Float> evenNumber, List<Float> perfectSquareNumber) {
        Number num = new Number();
        //Loop from first element to last element of list
        for (int i = 0; i < numbers.size(); i++) {
            //Check number is odd
            if (num.isOdd(numbers.get(i))) {
                oddNumber.add(numbers.get(i));
            } else {
                evenNumber.add(numbers.get(i));
            }
            //Check number is perfect square
            if (num.isPerfectSquare(numbers.get(i))) {
                perfectSquareNumber.add(numbers.get(i));
            }

        }
    }
}
