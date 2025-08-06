package org.example;

public class Transaction {
    private String transactionID;
    private String stockname;
    private long timeStamp;
    private double executedPrice;

    public Transaction(String stockname, double executedPrice){
        this.transactionID = generateTransactionID();
        this.stockname = stockname;
        this.timeStamp = System.currentTimeMillis();
        this.executedPrice = executedPrice;
    }

    public void printTransaction(){
        System.out.println("TransactionID: " + this.transactionID + " stockname " + this.stockname + " executed at " + executedPrice + " time " + timeStamp);
    }

    public String generateTransactionID(){
       return (Math.random()*10000000) + "";
    }
}
