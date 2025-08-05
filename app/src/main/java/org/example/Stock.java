package org.example;


import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Stock {
    private String name;
    private long availableQuantity;
    private double price;
    private PriorityBlockingQueue<Order> buyOrders;
    private PriorityBlockingQueue<Order> sellOrders;
    private double currentPrice;

    public double getCurrentPrice(){
        return this.currentPrice;
    }

    public void setCurrentPrice(double currentPrice){
        this.currentPrice = currentPrice;
    }

    public Stock(){
        this.buyOrders = new PriorityBlockingQueue<>(11, (t1,t2) -> {
            if(t1.getPrice() > t2.getPrice()){
                return 1;
            }else if(t1.getPrice() < t2.getPrice()){
                return -1;
            }else{
                return (int)(t1.getTimeStamp() - t2.getTimeStamp());
            }
        });
        this.sellOrders = new PriorityBlockingQueue<>(11, (t1,t2) -> {
            return (int)(t1.getPrice() - t2.getPrice());
        });
    }

    public void addBuyOrder(Order e){
        this.buyOrders.offer(e);
    }

    public Order getBuyOrderPeek(){
        //return this.buyOrders.peek();
        try {
            return this.buyOrders.poll(1000, TimeUnit.MILLISECONDS);
        }catch(Exception e){
            return null;
        }
        
    }

    public Order getSellOrderPeek(){
         try {
            return this.sellOrders.poll(1000, TimeUnit.MILLISECONDS);
        }catch(Exception e){
            return null;
        }
    }

    public void removeBuyOrderPeek(){
        try{
            this.buyOrders.take();
        }catch(Exception e){
            System.out.println("Error");
        }
    }

    public void removeSellOrderPeek(){
        try{
            this.sellOrders.take();
        }catch(Exception e){
            System.out.println("Error");
        }
    }


    public void addSellOrder(Order e){
        this.sellOrders.offer(e);
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
