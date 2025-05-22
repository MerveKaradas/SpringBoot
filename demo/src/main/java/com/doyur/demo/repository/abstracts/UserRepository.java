package com.doyur.demo.repository.abstracts;

import com.doyur.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("SELECT u FROM User u WHERE u.userEmail = :userEmail")
    Optional<User> findByUsername(@Param("userEmail") String userEmail);


    // Bu değişiklikle, findByUsername metodunun JPQL sorgusu artık userEmail alanını kullanacak. Bu sayede Spring Security,
    // doğrulama işlemlerini userEmail alanı üzerinden gerçekleştirecektir.

    // Bu örnekte UserRepository, JpaRepository'den türemiş ve User sınıfı için temel CRUD (Create, Read, Update, Delete)
    // işlemlerini sağlamaktadır. findByUserEmail metodu, e-posta adresine göre bir kullanıcıyı bulmak için kullanılabilir.
    // Eğer kullanıcı bulunamazsa, Optional.empty() dönecektir.

    Optional<User> findById(int id);

  //  Optional<User> findByEmailAndPassword(String email, String password);*/

   /*  @Query("SELECT u FROM User u WHERE u.userEmail = :username")
     Optional<User> findByUsername(@Param("username") String username);

     Bu çözümde, findByUsername metodu özel bir JPQL sorgusu kullanarak çalışacaktır ve username
      parametresini userEmail alanına göre arayacaktır.
     */



}
