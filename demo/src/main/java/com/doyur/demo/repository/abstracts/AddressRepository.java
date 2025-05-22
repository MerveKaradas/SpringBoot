package com.doyur.demo.repository.abstracts;

import com.doyur.demo.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
