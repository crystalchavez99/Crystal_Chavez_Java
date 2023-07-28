package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @BeforeEach
    public void setUp() throws Exception{
        customerRepository.deleteAll();
    }

    @Test
    public void shouldAddCustomer(){
        Customer customer = new Customer();
        customer.setFirstName("Leon");
        customer.setLastName("Kennedy");
        customer.setEmail("lkennedy@rpd.org");
        customer.setCompany("Umbrella Corporation");
        customer.setPhone("707-709-1998");
        customer.setAddress1("12345 Ennerdale Street");
        customer.setAddress2("Unit 1");
        customer.setCity("Raccoon City");
        customer.setState("New York");
        customer.setPostalCode("12345");
        customer.setCompany("USA");

        Customer customer2 = new Customer();
        customer2.setFirstName("Jill");
        customer2.setLastName("Valentine");
        customer2.setEmail("jValentine@rpd.org");
        customer2.setCompany("Umbrella Corporation");
        customer2.setPhone("707-709-1998");
        customer2.setAddress1("12345 Ennerdale Street");
        customer2.setAddress2("Unit 1");
        customer2.setCity("Raccoon City");
        customer2.setState("New York");
        customer2.setPostalCode("12345");
        customer2.setCompany("USA");

        customer = customerRepository.save(customer);
        customer2 = customerRepository.save(customer2);

        Optional<Customer> foundCustomer = customerRepository.findById(customer.getId());

        assertEquals(foundCustomer.get(), customer);
    }

    @Test
    public void shouldUpdateCustomer(){
        Customer customer = new Customer();
        customer.setFirstName("Leon");
        customer.setLastName("Kennedy");
        customer.setEmail("lkennedy@rpd.org");
        customer.setCompany("Umbrella Corporation");
        customer.setPhone("707-709-1998");
        customer.setAddress1("12345 Ennerdale Street");
        customer.setAddress2("Unit 1");
        customer.setCity("Raccoon City");
        customer.setState("New York");
        customer.setPostalCode("12345");
        customer.setCompany("USA");
        customer = customerRepository.save(customer);

        customer.setFirstName("Jill");
        customer.setLastName("Valentine");
        customer.setEmail("jValentine@rpd.org");
        customer.setCompany("Umbrella Corporation");
        customer.setPhone("707-709-1998");
        customer.setAddress1("12345 Ennerdale Street");
        customer.setAddress2("Unit 1");
        customer.setCity("Raccoon City");
        customer.setState("New York");
        customer.setPostalCode("12345");
        customer.setCompany("USA");
        customerRepository.save(customer);

        Optional<Customer> updatedCustomer = customerRepository.findById(customer.getId());

        assertEquals(updatedCustomer.get(), customer);
    }

    @Test
    public void shouldDeleteArtistById(){
        Customer customer = new Customer();
        customer.setFirstName("Leon");
        customer.setLastName("Kennedy");
        customer.setEmail("lkennedy@rpd.org");
        customer.setCompany("Umbrella Corporation");
        customer.setPhone("707-709-1998");
        customer.setAddress1("12345 Ennerdale Street");
        customer.setAddress2("Unit 1");
        customer.setCity("Raccoon City");
        customer.setState("New York");
        customer.setPostalCode("12345");
        customer.setCompany("USA");
        customer = customerRepository.save(customer);

        Optional<Customer> deleteCustomer = customerRepository.findById(customer.getId());

        assertEquals(deleteCustomer.get(), customer);

        customerRepository.deleteById(customer.getId());

        deleteCustomer = customerRepository.findById(customer.getId());

        assertFalse(deleteCustomer.isPresent());

    }

    @Test
    public void shouldGetCustomerById(){
        Customer customer = new Customer();
        customer.setFirstName("Leon");
        customer.setLastName("Kennedy");
        customer.setEmail("lkennedy@rpd.org");
        customer.setCompany("Umbrella Corporation");
        customer.setPhone("707-709-1998");
        customer.setAddress1("12345 Ennerdale Street");
        customer.setAddress2("Unit 1");
        customer.setCity("Raccoon City");
        customer.setState("New York");
        customer.setPostalCode("12345");
        customer.setCompany("USA");
        customer = customerRepository.save(customer);

        Customer customer2 = new Customer();
        customer2.setFirstName("Jill");
        customer2.setLastName("Valentine");
        customer2.setEmail("jValentine@rpd.org");
        customer2.setCompany("Umbrella Corporation");
        customer2.setPhone("707-709-1998");
        customer2.setAddress1("12345 Ennerdale Street");
        customer2.setAddress2("Unit 1");
        customer2.setCity("Raccoon City");
        customer2.setState("New York");
        customer2.setPostalCode("12345");
        customer2.setCompany("USA");
        customer2 = customerRepository.save(customer2);

        Optional<Customer> foundCustomer = customerRepository.findById(customer.getId());

        assertEquals(foundCustomer.get(), customer);
    }

    @Test
    public void shouldGetCustomerByState(){
        Customer customer = new Customer();
        customer.setFirstName("Leon");
        customer.setLastName("Kennedy");
        customer.setEmail("lkennedy@rpd.org");
        customer.setCompany("Umbrella Corporation");
        customer.setPhone("707-709-1998");
        customer.setAddress1("12345 Ennerdale Street");
        customer.setAddress2("Unit 1");
        customer.setCity("Raccoon City");
        customer.setState("New York");
        customer.setPostalCode("12345");
        customer.setCompany("USA");
        customer = customerRepository.save(customer);

        Customer customer2 = new Customer();
        customer2.setFirstName("Jill");
        customer2.setLastName("Valentine");
        customer2.setEmail("jValentine@rpd.org");
        customer2.setCompany("Umbrella Corporation");
        customer2.setPhone("707-709-1998");
        customer2.setAddress1("12345 Ennerdale Street");
        customer2.setAddress2("Unit 1");
        customer2.setCity("Raccoon City");
        customer2.setState("New York");
        customer2.setPostalCode("12345");
        customer2.setCompany("USA");
        customer2 = customerRepository.save(customer2);

        List<Customer> customerList = customerRepository.findByState("New York");

       assertEquals(customerList.size(), 2);
    }

}