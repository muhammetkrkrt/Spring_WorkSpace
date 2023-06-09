package com.movieapp.repository;

import com.movieapp.entity.MovieComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IMovieCommentRepository extends JpaRepository<MovieComment,Long> {

    List<MovieComment> findByUser_Name(String name);
    List<MovieComment> findByMovie_Name(String name);
    @Query("select m from MovieComment m where m.movie.name=?1 and m.date> ?2 and m.date<?3 ")
    List<MovieComment> findByMovieandDate(String name , LocalDate firstDate,LocalDate lastDate);

    @Query("select m from MovieComment m where m.movie.name=?1 and m.date> ?2 and m.date<?3 ")
    List<MovieComment> findByUserandDate(String name , LocalDate firstDate,LocalDate lastDate);

    List<MovieComment> findAllByContentContainingIgnoreCase(String content);
    @Query("SELECT m FROM MovieComment m WHERE LENGTH(m.content) > :length")
    List<MovieComment> findByContentLengthGreaterThan(int length);
}
