package com.codingworld.service1.repository;

import com.codingworld.service1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


/**
 * User Repository
 * 
 * @author Bhupendra
 *
 */
//@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String name);
    Optional<User> findByEmail(String email);
    Optional<User> findById(Long id);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

}
