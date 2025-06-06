package com.doyur.demo.repository.abstracts;

import com.doyur.demo.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
    Optional<Menu> findByMenuName(String menuName);
}
