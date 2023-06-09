package com.movieapp.repository;

import com.movieapp.entity.Genre;
import com.movieapp.entity.Movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAllByRatingGreaterThan(double rate);

    List<Movie> findAllByGenresInOrderByRatingDesc(List<Genre> genres);

    List<Movie> findAllByPremieredBefore(LocalDate date);
    @Query("select count(m.rating) ,m.rating from Movie as m where m.rating=?1  group by m.rating ")
    Object[] serchByRating(double rate);

    List<Movie> findAllByNameIn(String[] names);

    Movie findByName(String name);
}