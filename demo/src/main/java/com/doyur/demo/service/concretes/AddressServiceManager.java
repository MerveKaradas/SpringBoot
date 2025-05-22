package com.doyur.demo.service.concretes;

import com.doyur.demo.model.Address;
import com.doyur.demo.repository.abstracts.AddressRepository;
import com.doyur.demo.service.abstracts.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceManager implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceManager(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address findAddressById(int id) {
        return addressRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Address not found"));
    }

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(int id, Address address) {
        Address addressToUpdate = addressRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Address not found"));

        addressToUpdate.setAddressName(address.getAddressName());
        addressToUpdate.getCountyId().setCityId(address.getCountyId().getCityId());
        addressToUpdate.setCountyId(address.getCountyId());
        addressToUpdate.setFullAddress(address.getFullAddress());

        return addressRepository.save(addressToUpdate);

    }

    @Override
    public void deleteAddress(int id) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        if (addressOptional.isPresent()) {
            addressRepository.deleteById(id);
        }
        else {
            throw new IllegalArgumentException("Address not found");
        }
    }
}
