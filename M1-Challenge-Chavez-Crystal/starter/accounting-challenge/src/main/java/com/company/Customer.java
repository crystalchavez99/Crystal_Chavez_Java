package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

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

    public List<AccountRecord> getCharges() {
        return charges;
    }
    public int getBalance() {
        //update this
//        return 0;
        int balance = 0;
        for(AccountRecord charge: charges){
            balance += charge.getCharge();
        }
        return balance;
    }



    @Override
    public String toString() {
        //update this
        return "Customer { \n" +
                "id: "+ id+
                ",\nname: " +name+
                ",\nbalance: " + getBalance() +
                "\n}\n";
    }
}
