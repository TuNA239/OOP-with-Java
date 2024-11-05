/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fibonacci;

/**
 *
 * @author TUF GAMING
 */
public class Fibonacci {

    public static int fibonacciRecursion(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
    }

    public static void main(String args[]) {
        int maxNumber = 45;
        System.out.println("Fibonacci Series of " + maxNumber + " numbers: ");
        for (int i = 0; i < maxNumber; i++) {
            System.out.print(fibonacciRecursion(i) + " ");
        }
    }

}
