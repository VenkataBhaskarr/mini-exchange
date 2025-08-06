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
        // Buy orders: Highest price first, then by timestamp (FIFO for same price)
        this.buyOrders = new PriorityBlockingQueue<>(11, (t1,t2) -> {
            if(t1.getPrice() > t2.getPrice()){
                return -1;  // Higher price has higher priority
            }else if(t1.getPrice() < t2.getPrice()){
                return 1;
            }else{
                return (int)(t1.getTimeStamp() - t2.getTimeStamp());  // FIFO for same price
            }
        });
        // Sell orders: Lowest price first, then by timestamp (FIFO for same price)
        this.sellOrders = new PriorityBlockingQueue<>(11, (t1,t2) -> {
            if(t1.getPrice() < t2.getPrice()){
                return -1;  // Lower price has higher priority
            }else if(t1.getPrice() > t2.getPrice()){
                return 1;
            }else{
                return (int)(t1.getTimeStamp() - t2.getTimeStamp());  // FIFO for same price
            }
        });
    }

    public void addBuyOrder(Order e){
        this.buyOrders.offer(e);
    }

    public Order getBuyOrderPeek(){
        return this.buyOrders.peek();  // Non-blocking peek (doesn't remove)
    }

    public Order getSellOrderPeek(){
        return this.sellOrders.peek();  // Non-blocking peek (doesn't remove)
    }

    public Order pollBuyOrder(){
        return this.buyOrders.poll();  // Remove and return
    }

    public Order pollSellOrder(){
        return this.sellOrders.poll();  // Remove and return
    }

    public void printBuyOrders(){
        if(buyOrders.size() == 0){
            System.out.println("ZERO SIZE buy BABY");
        }
        for(Order ord: buyOrders){
           ord.printOrder();
        }
    }

    public void printSellOrders(){
        if(sellOrders.size() == 0){
            System.out.println("ZERO SIZE sell BABY");
        }
        for(Order ord: sellOrders){
           ord.printOrder();
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
