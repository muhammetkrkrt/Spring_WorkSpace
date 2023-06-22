package com.movieapp.repository;

import com.movieapp.entity.Genre;
import com.movieapp.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface IMovieRepository extends JpaRepository<Movie,Long> {


    List<Movie> findAllByGenres_NameIn(String[] genre);
}
