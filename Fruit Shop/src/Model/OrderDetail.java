/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Map;

/**
 *
 * @author TUF GAMING
 */
public class OrderDetail {
    private Map<Fruit, Integer> order;

    public OrderDetail() {
    }

    public OrderDetail(Map<Fruit, Integer> order) {
        this.order = order;
    }

    public Map<Fruit, Integer> getOrder() {
        return order;
    }

    public void setOrder(Map<Fruit, Integer> order) {
        this.order = order;
    }
    
    public double getTotalAmount(){
        double total = 0;
        for (Map.Entry<Fruit, Integer> entry : order.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }
}
