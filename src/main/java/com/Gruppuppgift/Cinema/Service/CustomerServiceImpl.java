package com.Gruppuppgift.Cinema.Service;

import com.Gruppuppgift.Cinema.DAO.CustomerRepository;
import com.Gruppuppgift.Cinema.Entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        System.out.println("Saved customer");
        return customerRepository.save(customer);
    }
    @Override
    public List<Customer> findAllCustomers() {
        System.out.println("Found all customers");
        return customerRepository.findAll();
    }
    @Override
    public void deleteCustomerById(int customerId){
        System.out.println("Removed customer from database");
        customerRepository.deleteById(customerId);
    }

}
