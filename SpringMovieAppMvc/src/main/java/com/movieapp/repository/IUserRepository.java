package com.movieapp.repository;

import com.movieapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<User,Long> {

    Boolean existsByEmail(String email);

    Optional<User> findByEmailIgnoreCaseAndPassword(String email, String password);
}
