package com.movieapp.repository;

import com.movieapp.entity.MovieComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface IMovieCommentRepository extends JpaRepository<MovieComment,Long> {

}
