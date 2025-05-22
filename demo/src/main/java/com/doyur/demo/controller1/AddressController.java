package com.doyur.demo.controller1;

import com.doyur.demo.model.Address;
import com.doyur.demo.service.abstracts.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/addresses")
public class AddressController {

    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Address>> getAllAddresses() {
        return ResponseEntity.ok(addressService.getAllAddresses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(int id) {
        return ResponseEntity.ok(addressService.findAddressById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        Address newAddress = addressService.saveAddress(address);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAddress);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable int id, @RequestBody Address address) {
        return ResponseEntity.ok(addressService.updateAddress(id, address));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable int id) {
        addressService.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }
}
