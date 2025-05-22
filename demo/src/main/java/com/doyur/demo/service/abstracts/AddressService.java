package com.doyur.demo.service.abstracts;

import com.doyur.demo.model.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAllAddresses();

    Address findAddressById(int id);

    Address saveAddress(Address address);

    Address updateAddress(int id, Address address);

    void deleteAddress(int id);
}
