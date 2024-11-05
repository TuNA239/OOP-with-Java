/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Fruit;
import Model.Order;
import Model.OrderDetail;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author TUF GAMING
 */
public class View {

    public void displayMenu() {
        System.out.println("\n========== FRUIT SHOP SYSTEM ==========");
        System.out.println("1. Create Fruit");
        System.out.println("2. View Orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
        System.out.println("=======================================");
    }

    public void displayFruits(ArrayList<Fruit> listFruit) {
        //Check list fruit is empty
        if (listFruit.isEmpty()) {
            System.out.println("No fruits available!!");
        } else {
            System.out.println("\n==================== Fruit List ====================");
            System.out.printf("%-5s | %-15s | %-10s | %-6s\n", "Item", "Fruit Name", "Origin", "Price");
            System.out.println("------------------------------------------------------");
            //Access through each element of list fruit
            for (Fruit f : listFruit) {
                System.out.printf("%-5d | %-15s | %-10s | $%-6.2f\n", (listFruit.indexOf(f)+1), f.getName(), f.getOrigin(), f.getPrice());
            }
            System.out.println("======================================================");
        }
    }

    public void displayOrderDetail(OrderDetail o) {
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-15s | %-10s | %-6s | %-6s\n", "Product", "Quantity", "Price", "Amount");
        System.out.println("------------------------------------------------------------");
        //Loop through each element of order
        for (Map.Entry<Fruit, Integer> itr : o.getOrder().entrySet()) {
            Fruit f = itr.getKey();
            System.out.printf("%-15s | %-10d | $%-6.2f | $%-6.2f\n", f.getName(), itr.getValue(), f.getPrice(), f.getPrice() * itr.getValue());
        }
        System.out.printf("Total: $%.2f\n", o.getTotalAmount());
    }

    public void displayAllOrders(ArrayList<Order> listOrder) {
        //Check list order is empty
        if (listOrder.isEmpty()) {
            System.out.println("No order yet");
        } else {
            System.out.println("==================== Customer Orders ====================");
            //Loop through each element of list order
            for (Order o : listOrder) {
                System.out.println("Customer name: " + o.getCustomerName());
                displayOrderDetail(o.getOrder());
            }
        }
    }

    public void displayCheckout(Order o) {
        System.out.println("\n==================== Checkout Summary ====================");
        displayOrderDetail(o.getOrder());
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
