package com.Gruppuppgift.Cinema.Service;

import com.Gruppuppgift.Cinema.Entities.Address;

import java.util.Optional;

public interface AddressService {

    Optional<Address> findById(int id);
}
