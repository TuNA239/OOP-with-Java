/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

// Controller.java
import Model.CustomerOrder;
import Model.Fruit;
import Model.Order;
import View.View;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Controller {

    private ArrayList<Fruit> fruitList = new ArrayList<>();
    private ArrayList<CustomerOrder> orders = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private View view;

    public Controller(View view) {
        this.view = view;
    }

    public void start() {
        while (true) {
            view.displayMainMenu();
            int choice = sc.nextInt();
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
        sc.nextLine(); // Consume newline
        while (true) {
            System.out.print("Enter Fruit ID: ");
            String id = sc.nextLine();
            System.out.print("Enter Fruit Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Fruit Price: ");
            double price = sc.nextDouble();
            System.out.print("Enter Fruit Quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine(); // Consume newline
            System.out.print("Enter Fruit Origin: ");
            String origin = sc.nextLine();

            fruitList.add(new Fruit(id, name, price, quantity, origin));

            System.out.print("Do you want to continue (Y/N)? ");
            String cont = sc.nextLine();
            if (cont.equalsIgnoreCase("N")) {
                view.displayFruits(fruitList);
                break;
            }
        }
    }

    private void viewOrders() {
        view.displayCustomerOrders(orders);
    }

    private void shopping() {
        if (fruitList.isEmpty()) {
            view.displayMessage("No fruits available for shopping.");
            return;
        }
        
        sc.nextLine();
        CustomerOrder customerOrder = new CustomerOrder(inputCustomerName());
        while (true) {
            view.displayFruits(fruitList);

            System.out.print("Please select item number: ");
            int item = sc.nextInt();
            if (item < 1 || item > fruitList.size()) {
                view.displayMessage("Invalid item. Please select again.");
                continue;
            }

            Fruit selectedFruit = fruitList.get(item - 1);
            System.out.println("You selected: " + selectedFruit.getName());
            System.out.print("Please input quantity: ");
            int quantity = sc.nextInt();

            if (quantity > selectedFruit.getQuantity()) {
                view.displayMessage("Not enough stock available.");
                continue;
            }

            selectedFruit.setQuantity(selectedFruit.getQuantity() - quantity);
            customerOrder.addOrder(new Order(selectedFruit, quantity));

            System.out.print("Do you want to order now (Y/N)? ");
            sc.nextLine(); // Consume newline
            String orderNow = sc.nextLine();
            if (orderNow.equalsIgnoreCase("Y")) {
                checkout(customerOrder);
                break;
            }
        }
    }

    private String inputCustomerName() {
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();
        return name;
    }

    private void checkout(CustomerOrder customerOrder) {
        orders.add(customerOrder);
        view.displayCheckoutSummary(customerOrder);
        view.displayMessage("Thank you for your order!");
    }
}
