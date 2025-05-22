package com.doyur.demo.configuration;

import com.doyur.demo.model.Role;
import com.doyur.demo.model.User;
import com.doyur.demo.repository.abstracts.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class AdminInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AdminInitializer(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        // Check if an admin user already exists
        if (userRepository.findByUsername("admin@localhost").isEmpty()) {

            Set<Role> allRoles = new HashSet<>(Arrays.asList(Role.values()));
            User adminUser = new User();

            adminUser.setUserFName("admin");
            adminUser.setUserLName("admin");
            adminUser.setUserPassword(passwordEncoder.encode("adminPassword"));
            adminUser.setUserEmail("admin@localhost");
            adminUser.setUserPhone("5301112223");
            adminUser.setAuthorities(allRoles);;
            adminUser.setEnabled(true);
            adminUser.setAccountNonExpired(true);
            adminUser.setAccountNonLocked(true);
            adminUser.setCredentialsNonExpired(true);

            userRepository.save(adminUser);
        }
    }
}