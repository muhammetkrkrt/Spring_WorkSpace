package com.movieapp.repository;

import com.movieapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    List<User> findAllByOrderByName();
    List<User> findByNameContaining(String search);

    List<User> findByEmailLike(String mail);

    List<User> findAllByEmailEndsWith(String value);
    List<User> findAllByEmailEndingWith(String value);
    List<User> findAllByEmailStartingWith(String value);
    Boolean existsByEmailAndPassword(String mail,String password);

    Optional<User> findByEmailAndPassword(String mail , String password);

    @Query("SELECT u FROM User u WHERE length(u.password) >:x")
    List<User> passwordLongerThan(String password);
}
