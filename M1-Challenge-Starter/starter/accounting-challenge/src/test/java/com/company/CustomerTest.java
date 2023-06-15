package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    Customer customer;
    Customer customer1;
    Customer customer2;
    @BeforeEach
    void setUp() {
        customer = new Customer();
        customer1 = new Customer();
        customer2 = new Customer();
    }

    @Test
    void getBalanceWithPositive() {
        AccountRecord charge = new AccountRecord();
        charge.setCharge(150);
        customer.getCharges().add(charge);
        AccountRecord charge2 = new AccountRecord();
        charge2.setCharge(200);
        customer.getCharges().add(charge2);
        assertEquals(350, customer.getBalance());
    }

    @Test
    void getBalanceWithNegative() {
        AccountRecord charge = new AccountRecord();
        charge.setCharge(150);
        customer1.getCharges().add(charge);
        AccountRecord charge2 = new AccountRecord();
        charge2.setCharge(-200);
        customer1.getCharges().add(charge2);
        assertEquals(-50, customer1.getBalance());
    }

    @Test
    void getBalanceWithZero() {
        assertEquals(0, customer2.getBalance());
    }

    @Test
    void testToString() {
        customer1.setId(1);
        customer1.setName("Riot Games");
        AccountRecord charge = new AccountRecord();
        charge.setCharge(150);
        customer1.getCharges().add(charge);
        String result = "Customer { \nid: 1,\nname: Riot Games,\nbalance: 150\n}\n";
        assertEquals(result, customer1.toString());
    }
}