package com.Gruppuppgift.Cinema.DAO;


import com.Gruppuppgift.Cinema.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {


}


