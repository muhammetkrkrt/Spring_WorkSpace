package com.movieapp.service;

import com.movieapp.entity.Movie;
import com.movieapp.repository.IMovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final IMovieRepository movieRepository;
    private final UserService userService;
    private final GenreService genreService;

    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie findById(Long id) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()) {
            return optionalMovie.get();
        } else {
            throw new RuntimeException("Film bulunamadi");
        }
    }

    public List<Movie> findAllByIds(List<Long> ids) {
        return ids.stream().map(x -> movieRepository.findById(x).get()).collect(Collectors.toList());
    }

    public List<Movie> findAllByRatingGreaterThan(double rate) {
        return movieRepository.findAllByRatingGreaterThan(rate);
    }

    public List<Movie> findMoviesByUserGenres(Long id) {
        return movieRepository.findAllByGenresInOrderByRatingDesc(genreService.findGenreList(id));
    }

    public List<Movie> findAllByPremieredBefore(LocalDate date) {
        return movieRepository.findAllByPremieredBefore(date);
    }

    public Object[] serchByRating(double rate) {
        return movieRepository.serchByRating(rate);
    }

    public List<Movie> findAllByNameIn(String[] names){
        return movieRepository.findAllByNameIn(names);
    }


}


