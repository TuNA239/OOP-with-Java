
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author TUF GAMING
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("===== Showroom car program =====");
        //Get input from user and check car
        getInputData();

    }

    public static boolean checkInputYesNo() {
        Scanner sc = new Scanner(System.in);
        //Loop unitl input is valid
        while (true) {
            System.out.print("Do you want to find more? (Y/N): ");
            String input = sc.nextLine();
            //Check input is Y or y
            if (input.contentEquals("Y") || input.contentEquals("y")) {
                return true;
            } //Check input is N or n
            else if (input.contains("N") || input.contentEquals("n")) {
                return false;
            } else {
                System.out.println("Input is invalid. Please enter Y/N !!");
            }
        }
    }

    public static int inputPrice() {
        Scanner sc = new Scanner(System.in);
        //Loop until input is valid
        while (true) {
            try {
                System.out.print("Price: ");
                int input = Integer.parseInt(sc.nextLine());
                //Check number is not positive
                if (input <= 0) {
                    System.out.println("Price is invalid. Please input a positive number!! ");
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println("Price is invalid. Please input a positive number!!");
            }
        }
    }

    private static void getInputData() {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        //Loop until user exit
        while (flag) {
            System.out.println("Input information of Car");
            System.out.print("Name: ");
            String name = sc.nextLine();
            Car car = Car.getCar(name);
            System.out.print("Color: ");
            String colorName = sc.nextLine();
            Color color = Color.getColor(colorName);
            System.out.print("Price: ");
            String price = sc.nextLine();
            System.out.print("Today: ");
            String today = sc.nextLine();
            Day day = Day.getDay(today);

            try {
                checkCar(car, color, price, day);
            } catch (ExceptionCar e) {
                System.out.println(e.getMessage());
            }

            flag = checkInputYesNo();
        }

    }

    private static Car checkCar(Car car, Color color, String price, Day day) throws ExceptionCar {

        if (car == null) {
            throw new ExceptionCar("Can't sell Car\nCar break");
        } else {
            boolean colorMatch = Arrays.stream(car.getColors()).anyMatch(c -> c == color || color == Color.NO_COLOR);
            if (!colorMatch) {
                throw new ExceptionCar("Can't sell Car\nColor Car does not exist");
            }
            try {
                int carPrice = Integer.parseInt(price);
                if (carPrice < 0) {
                    throw new ExceptionCar("Can't sell Car\nPrice greater than zero");
                }
            } catch (NumberFormatException e) {
                throw new ExceptionCar("Can't sell Car\nPrice is digit");
            }
            boolean priceMatch = Arrays.stream(car.getPrices()).anyMatch(p -> p == Integer.parseInt(price));
            if (!priceMatch) {
                throw new ExceptionCar("Can't sell Car\nPrice greater than zero");
            }

            boolean dayMatch = Arrays.stream(car.getDaySells()).anyMatch(d -> d == day);
            if (!dayMatch) {
                throw new ExceptionCar("Can't sell Car\nCar can't sell today");
            }
            return car;
        }
    }

}
