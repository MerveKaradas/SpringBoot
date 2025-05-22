package com.doyur.demo.repository.abstracts;

import com.doyur.demo.model.Cities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitiesRepository extends JpaRepository<Cities, Integer> {
}
