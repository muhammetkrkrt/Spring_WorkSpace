package com.movieapp.service;

import com.movieapp.entity.Movie;
import com.movieapp.entity.MovieComment;
import com.movieapp.repository.IMovieCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieCommentService {

    private final IMovieCommentRepository iMovieCommentRepository;

    public List<MovieComment> findByMovie_Name(String name){

        return iMovieCommentRepository.findByMovie_Name(name);
    }
    public List<MovieComment> findByUser_Name(String name){
        return iMovieCommentRepository.findByUser_Name(name);
    }
    public List<MovieComment> findByMovieandDate(String name, LocalDate firstDate ,LocalDate lastDate){
        return iMovieCommentRepository.findByMovieandDate(name,firstDate,lastDate);
    }
    public List<MovieComment> findByUserandDate(String name, LocalDate firstDate ,LocalDate lastDate){
        return iMovieCommentRepository.findByUserandDate(name,firstDate,lastDate);
    }
    public List<MovieComment> findAllByContent(String content){
        return iMovieCommentRepository.findAllByContentContainingIgnoreCase(content);
    }
    public List<MovieComment> findByContentLengthGreaterThan(int length){
        return iMovieCommentRepository.findByContentLengthGreaterThan(length);
    }




}
