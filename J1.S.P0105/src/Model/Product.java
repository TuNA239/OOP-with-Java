/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author TUF GAMING
 */
public class Product {
    private int id;
    private String name;
    private String location;
    private double price;
    private Date expiryDate;
    private Date dateOfManufacture;
    private String category;
    private String storekeeper;
    private Date receiptDate;

    public Product() {
    }

    public Product(int id, String name, String location, double price, Date expiryDate, Date dateOfManufacture, String category, String storekeeper, Date receiptDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.price = price;
        this.expiryDate = expiryDate;
        this.dateOfManufacture = dateOfManufacture;
        this.category = category;
        this.storekeeper = storekeeper;
        this.receiptDate = receiptDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(Date dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStorekeeper() {
        return storekeeper;
    }

    public void setStorekeeper(String storekeeper) {
        this.storekeeper = storekeeper;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }
    
     
    
}
