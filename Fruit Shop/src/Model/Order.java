/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author TUF GAMING
 */
public class Order {
    private String customerName;
    private OrderDetail order;

    public Order() {
    }

    public Order(String customerName, OrderDetail order) {
        this.customerName = customerName;
        this.order = order;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public OrderDetail getOrder() {
        return order;
    }

    public void setOrder(OrderDetail order) {
        this.order = order;
    }
}
