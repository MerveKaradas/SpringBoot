package com.doyur.demo.service.concretes;

import com.doyur.demo.dto.request.CreateUserRequest;
import com.doyur.demo.model.Role;
import com.doyur.demo.model.User;
import com.doyur.demo.repository.abstracts.UserRepository;
import com.doyur.demo.service.abstracts.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
//@transational
public class UserServiceManager implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceManager(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Optional<User> getByEmail(String userEmail){
        return userRepository.findByUsername(userEmail);
    }

    public User save(CreateUserRequest request){ //createUser metodu

        Set<Role> authorities = (request.getAuthorities() != null) ? new HashSet<>(request.getAuthorities()) : new HashSet<>();
       authorities.add(Role.ROLE_USER);
        // request.getAuthorities()'ın null olup olmadığı kontrol edilir. Eğer null ise, yeni bir HashSet
        // oluşturulur ve bu sete ROLE_USER eklenir. Eğer null değilse, mevcut set üzerine ROLE_USER eklenir.
        // Bu, request.getAuthorities()'ın null olup olmamasına bağlı olarak güvenli bir şekilde çalışır ve
        // null durumlarına karşı bir önlem alır.

        if (request.getUserPassword() == null) {
            throw new IllegalArgumentException("User password cannot be null");
        }

        User newUser = new User(
                request.getUserFName(),
                request.getUserLName(),
                bCryptPasswordEncoder.encode(request.getUserPassword()),
                request.getUserEmail(),
                request.getUserPhone(),
               // request.getAuthorities(),
                authorities,
                true,
                true,
                true,
                true
        );

        return userRepository.save(newUser);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));

    }

    @Override
    public User createUser(User user) {
        Optional<User> userByEmail = userRepository.findByUsername(user.getUserEmail());
        if (userByEmail.isPresent()) {
            throw new IllegalArgumentException("User already exists");
        }
        return userRepository.save(user);
    }

    @Override
    public User updateUser(int id, User user) {
        User userToUpdate = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        userToUpdate.setUserFName(user.getUserFName());
        userToUpdate.setUserLName(user.getUserLName());
        userToUpdate.setUserEmail(user.getUserEmail());
        userToUpdate.setUserPhone(user.getUserPhone());
        userToUpdate.setAuthorities(user.getAuthorities());
        return userRepository.save(userToUpdate);
    }

    public boolean userExists(int userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.isPresent();
    }

    @Override
    public void deleteUser(int id) {
        if (!userExists(id)) { //eğer kullanıcı bulunamazsa hata mesajı döndürür
            throw new IllegalArgumentException("User not found");
        }else
        {
            userRepository.deleteById(id); //başarılı bir silme işlemi durumunda HTTP 204 NO CONTENT yanıtını döndürür.
        }

    }

    //BUILDER KULLANIMINDA SAVE METODU
   /* public User save(CreateUserRequest request){ //createUser metodu
        User newUser = User.builder()
                .userFName(request.getUserFName())
                .userLName(request.getUserLName())
                .userPassword(bCryptPasswordEncoder.encode(request.getUserPassword()))
                .userEmail(request.getUserEmail())
                .userPhone(request.getUserPhone())
                .authorities(request.getAuthorities())
                .accountNonExpired(true)
                .isEnabled(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .build();

        return userRepository.save(newUser);
    } */

}
