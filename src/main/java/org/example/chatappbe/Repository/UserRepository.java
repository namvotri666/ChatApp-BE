package org.example.chatappbe.Repository;

import org.example.chatappbe.Model.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByEmail(String email);
    boolean existsByPhoneNum(String phoneNum);
    Optional<User> findByUsername(String username);
}