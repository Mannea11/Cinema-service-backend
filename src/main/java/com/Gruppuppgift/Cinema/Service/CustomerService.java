package com.Gruppuppgift.Cinema.Service;

import com.Gruppuppgift.Cinema.Entities.Customer;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
    List<Customer> findAllCustomers();
    void deleteCustomerById(int customerId);

}


