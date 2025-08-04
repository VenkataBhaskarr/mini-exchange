package org.example;

public class Order {
    private String orderID;
    private String stock;
    private int quantity;
    private double price;
    private long timeStamp;
    private int start = 00000000;

   

    public Order(String stock, int quantity, double price) {
        this.orderID = generateRandomOrderId();
        this.stock = stock;
        this.quantity = quantity;
        this.price = price;
        this.timeStamp = System.currentTimeMillis();
    }

    public String generateRandomOrderId(){
        return (start++) + "";
    }
   

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
    
}
