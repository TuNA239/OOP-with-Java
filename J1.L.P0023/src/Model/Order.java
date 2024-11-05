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
    private Fruit fruit;
    private int quantity;

    public Order(Fruit fruit, int quantity) {
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getAmount() {
        return fruit.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return String.format("%s\t%d\t%.2f$\t%.2f$", fruit.getName(), quantity, fruit.getPrice(), getAmount());
    }
}