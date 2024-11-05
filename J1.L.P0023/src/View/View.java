/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

// View.java
import Model.CustomerOrder;
import Model.Fruit;
import Model.Order;
import java.util.ArrayList;

// View.java
import java.util.ArrayList;

public class View {

    // Method to display the main menu
    public void displayMainMenu() {
        System.out.println("\n======== FRUIT SHOP SYSTEM ========");
        System.out.println("1. Create Fruit");
        System.out.println("2. View Orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
        System.out.println("===================================");
        System.out.print("Please choose: ");
    }

    // Method to display the list of available fruits
    public void displayFruits(ArrayList<Fruit> fruits) {
        if (fruits.isEmpty()) {
            System.out.println("No fruits available.");
        } else {
            System.out.println("\n==================== Fruit List ====================");
            System.out.printf("%-5s | %-15s | %-10s | %-6s\n", "Item", "Fruit Name", "Origin", "Price");
            System.out.println("-----------------------------------------------------");
            for (int i = 0; i < fruits.size(); i++) {
                Fruit fruit = fruits.get(i);
                System.out.printf("%-5d | %-15s | %-10s | $%-6.2f\n", (i + 1), fruit.getName(), fruit.getOrigin(), fruit.getPrice());
            }
            System.out.println("=====================================================");
        }
    }

    // Method to display customer orders
    public void displayCustomerOrders(ArrayList<CustomerOrder> orders) {
        if (orders.isEmpty()) {
            System.out.println("No orders yet.");
        } else {
            System.out.println("\n=============== Customer Orders ================");
            for (CustomerOrder order : orders) {
                System.out.println("Customer: " + order.getCustomerName());
                System.out.println("-------------------------------------------------");
                System.out.printf("%-15s | %-10s | %-6s | %-6s\n", "Product", "Quantity", "Price", "Amount");
                System.out.println("-------------------------------------------------");
                for (Order item : order.getOrderList()) {
                    System.out.printf("%-15s | %-10d | $%-6.2f | $%-6.2f\n", item.getFruit().getName(), item.getQuantity(), item.getFruit().getPrice(), item.getAmount());
                }
                System.out.printf("Total: $%.2f\n", order.getTotalAmount());
                System.out.println("===============================================");
            }
        }
    }

    // Method to display the checkout summary for a customer
    public void displayCheckoutSummary(CustomerOrder order) {
        System.out.println("\n==================== Checkout Summary ====================");
        System.out.printf("%-15s | %-10s | %-6s | %-6s\n", "Product", "Quantity", "Price", "Amount");
        System.out.println("-----------------------------------------------------------");
        for (Order item : order.getOrderList()) {
            System.out.printf("%-15s | %-10d | $%-6.2f | $%-6.2f\n", item.getFruit().getName(), item.getQuantity(), item.getFruit().getPrice(), item.getAmount());
        }
        System.out.printf("Total: $%.2f\n", order.getTotalAmount());
        System.out.println("===========================================================");
    }

    // Method to display any message to the user
    public void displayMessage(String message) {
        System.out.println(message);
    }
}
