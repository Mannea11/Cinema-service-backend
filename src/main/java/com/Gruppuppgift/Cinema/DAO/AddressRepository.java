package com.Gruppuppgift.Cinema.DAO;

import com.Gruppuppgift.Cinema.Entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
