/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

public class CustomerOrder {
    private String customerName;
    private ArrayList<Order> orderList = new ArrayList<>();

    public CustomerOrder(String customerName) {
        this.customerName = customerName;
    }

    public void addOrder(Order order) {
        orderList.add(order);
    }

    public String getCustomerName() {
        return customerName;
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public double getTotalAmount() {
        double total = 0;
        for (Order order : orderList) {
            total += order.getAmount();
        }
        return total;
    }
}