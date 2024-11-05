/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package j1.s.p0066;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author TUF GAMING
 */
public class J1SP0066 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("===== Showroom car program =====");
            System.out.println("Input Information of Car");

            System.out.print("Name: ");
            String carName = sc.nextLine();
            Car car = Car.getCar(carName);

            System.out.print("Color: ");
            String colorName = sc.nextLine();
            Color color = Color.getColor(colorName);

            System.out.print("Price: ");
            String priceInput = sc.nextLine();
            int price = 0;
            try {
                price = Integer.parseInt(priceInput);
                if (price < 0) {
                    System.out.println("Can't sell Car\nPrice greater than zero");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Can't sell Car\nPrice is digit");
                continue;
            }

            System.out.print("Today: ");
            String dayName = sc.nextLine();
            Day day = Day.getDay(dayName);

            if (color == Color.NO_COLOR) {
                price -= 100; // Apply the $100 discount for no color
            }

            try {
                Car matchedCar = checkCar(car, color, day, price);
                System.out.println("Sell Car");
                System.out.print("Do you want to find more? (Y/N): ");
                String choice = sc.nextLine();
                if (choice.equalsIgnoreCase("N")) {
                    break;
                }
            } catch (ExceptionCar e) {
                System.out.println(e.getMessage());
            }
        }

        sc.close();
    }
    public static Car checkCar(Car car, Color color, Day day, int price) throws ExceptionCar {
        if (car == null) {
            throw new ExceptionCar("Can't sell Car\nCar break");
        }

        boolean priceMatch = Arrays.stream(car.getPrices()).anyMatch(p -> p == price);
        if (!priceMatch) {
            throw new ExceptionCar("Can't sell Car\nPrice greater than zero");
        }

        boolean colorMatch = Arrays.stream(car.getColors()).anyMatch(c -> c == color || color == Color.NO_COLOR);
        if (!colorMatch) {
            throw new ExceptionCar("Can't sell Car\nColor Car does not exist");
        }

        boolean dayMatch = Arrays.stream(car.getDaySells()).anyMatch(d -> d == day);
        if (!dayMatch) {
            throw new ExceptionCar("Can't sell Car\nCar can't sell today");
        }

        return car;
    }
}
