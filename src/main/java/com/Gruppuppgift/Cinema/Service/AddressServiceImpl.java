package com.Gruppuppgift.Cinema.Service;

import com.Gruppuppgift.Cinema.DAO.AddressRepository;
import com.Gruppuppgift.Cinema.Entities.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;
    @Override
    public Optional<Address> findById(int id) {
        return addressRepository.findById(id);

        }
    }

