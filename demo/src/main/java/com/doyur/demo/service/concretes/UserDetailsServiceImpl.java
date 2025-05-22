package com.doyur.demo.service.concretes;

import com.doyur.demo.model.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserServiceManager userService;

    public UserDetailsServiceImpl(UserServiceManager userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<User> user = userService.getByEmail(email);

        return user.orElseThrow(EntityNotFoundException::new);
    }

}
