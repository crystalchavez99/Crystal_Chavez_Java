package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );





    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();



        for(int i = 0; i < customerData.size(); i++){
            boolean exists = false;
            int id = Integer.parseInt(customerData.get(i)[0]);
            String name = customerData.get(i)[1];
            int balance = Integer.parseInt(customerData.get(i)[2]);


            for(Customer current: customers){
                if(current.getName().equals(name)){
                    exists = true;
                  AccountRecord customerRecord = new AccountRecord();
                  customerRecord.setCharge(balance);
                  current.getCharges().add(customerRecord);

                }
            }

            if(exists == false){
                Customer customer = new Customer();
                customer.setId(id);
                customer.setName(name);
                AccountRecord customerRecord = new AccountRecord();
                customerRecord.setCharge(balance);
                customer.getCharges().add(customerRecord);
//                customer.setCharge(charge);
                customers.add(customer);
            }
        };
        //Update this
        List<Customer> positiveBalance = new ArrayList<>();
        List<Customer> negativeBalance = new ArrayList<>();
        for(Customer customer: customers){
            int customerBalance = customer.getBalance();
            if(customerBalance > 0){
                positiveBalance.add(customer);
            }else if (customerBalance < 0){
                negativeBalance.add(customer);
            }
        }
        System.out.println("Positive accounts:");
        for(Customer customer: positiveBalance){
            System.out.println(customer);
        }

        System.out.println("Negative accounts:");
        for(Customer customer: negativeBalance){
            System.out.println(customer);
        }
    }
}
