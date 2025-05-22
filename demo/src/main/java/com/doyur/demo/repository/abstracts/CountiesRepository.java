package com.doyur.demo.repository.abstracts;

import com.doyur.demo.model.Counties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountiesRepository extends JpaRepository<Counties, Integer> {
}
