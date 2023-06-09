package com.movieapp.repository;

import com.movieapp.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IGenreRepository extends JpaRepository<Genre,Long> {

    Optional<Genre> findOptionalByName(String name);

    @Query("select u.favGenres from User u where u.id =?1")
    List<Genre> findGenreList(Long id);
}
