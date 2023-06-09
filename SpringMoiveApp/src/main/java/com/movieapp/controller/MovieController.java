package com.movieapp.controller;

import com.movieapp.entity.Genre;
import com.movieapp.entity.Movie;
import com.movieapp.service.MovieService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/greaterthan")
    public ResponseEntity<List<Movie>> findAllByRatingGreaterThan(double rate){
        return ResponseEntity.ok(movieService.findAllByRatingGreaterThan(rate));
    }
    @GetMapping("/findmoviesbygeneres")
    public ResponseEntity<List<Movie>> findMoviesByUserGenres(Long id){
        return ResponseEntity.ok(movieService.findMoviesByUserGenres(id));
    }

    @GetMapping("/findbeforedate")
    public ResponseEntity<List<Movie>> findAllByPremieredBefore(LocalDate date){
        return ResponseEntity.ok(movieService.findAllByPremieredBefore(date));
    }
    @GetMapping("/searchrating")
    public ResponseEntity<Object[]> findAllByPremieredBefore(double rate){
        return ResponseEntity.ok(movieService.serchByRating(rate));
    }

    @GetMapping("/findAllByNameIn")
    public ResponseEntity<List<Movie>> findAllByNameIn(String[] names){
        return ResponseEntity.ok(movieService.findAllByNameIn(names));
    }
}
