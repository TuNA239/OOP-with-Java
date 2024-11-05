/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Fruit;
import Model.Order;
import Model.OrderDetail;
import View.View;
import Validation.Validate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author TUF GAMING
 */
public class Controller {

    private ArrayList<Fruit> listFruit = new ArrayList<>();
    private ArrayList<Order> listOrder = new ArrayList<>();
    private View view;
    private Validate v = new Validate();

    public Controller(View view) {
        this.view = view;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        //Loop until user exit
        while (true) {
            view.displayMenu();
            int choice = v.getPositiveInteger("Enter your choice: ", "Input is invalid. Please enter a positive number!!");
            switch (choice) {
                case 1:
                    createFruit();
                    break;
                case 2:
                    viewOrders();
                    break;
                case 3:
                    shopping();
                    break;
                case 4:
                    view.displayMessage("Exiting the program...");
                    return;
                default:
                    view.displayMessage("Invalid choice. Please try again.");
            }
        }
    }

    private void createFruit() {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            int id = v.inputFruitId(listFruit);
            String name = v.getInputString("Enter fruit name: ", "Name is invalid. Please enter again!!");
            double price = v.getPositiveDouble("Enter price: ", "Input is invalid. Please enter a positive number!!");
            int quantity = v.getPositiveInteger("Enter quantity: ", "Input is invalid. Pleasae enter a positive number");
            String origin = v.getInputString("Enter origin: ", "Input is invalid. Please enter again");

            listFruit.add(new Fruit(id, name, price, quantity, origin));

            flag = v.checkInputYesNo("Do you want to continue? (Y/N): ");
        }
        view.displayFruits(listFruit);
    }

    private void viewOrders() {
        view.displayAllOrders(listOrder);
    }

    private void shopping() {
        Scanner sc = new Scanner(System.in);
        Map<Fruit, Integer> itemList = new HashMap<>();
        boolean flag = true;

        //Loop until user exit
        while (flag) {
            view.displayFruits(listFruit);
            Fruit f = v.getFruitByIndex(listFruit);
            System.out.println("You selected: " + f.getName());
            int quantity = v.getQuantityItemOrdered(f);

            // Check if selected item already exists in the cart
            if (itemList.containsKey(f)) {
                itemList.put(f, itemList.get(f) + quantity);
            } else {
                // Add new item if it doesn't exist
                itemList.put(f, quantity);
            }
            flag = v.checkInputYesNo("Do you want to continue? (Y/N): ");
        }
        OrderDetail orderDetail = new OrderDetail(itemList);
        view.displayOrderDetail(orderDetail);
        String customerName = v.getInputString("Input your name: ", "Name is invalid. Please enter again!!");
        Order o = new Order(customerName, orderDetail);
        listOrder.add(o);
    }
}
