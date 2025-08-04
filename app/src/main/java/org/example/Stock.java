package org.example;

import java.util.concurrent.PriorityBlockingQueue;

public class Stock {
    private String name;
    private long availableQuantity;
    private double price;
    private PriorityBlockingQueue<Order> buyOrders;
    private PriorityBlockingQueue<Order> sellOrders;

    public Stock(){
        this.buyOrders = new PriorityBlockingQueue<>();
        this.sellOrders = new PriorityBlockingQueue<>();
    }

    public void addBuyOrder(Order e){
        this.buyOrders.add(e);
    }
    public void addSellOrder(Order e){
        this.sellOrders.add(e);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(long availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
