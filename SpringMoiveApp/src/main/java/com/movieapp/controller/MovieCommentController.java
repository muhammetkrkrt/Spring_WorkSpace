package com.movieapp.controller;

import com.movieapp.entity.MovieComment;
import com.movieapp.service.MovieCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/moviecomment")
@RequiredArgsConstructor
public class MovieCommentController {

    private final MovieCommentService movieCommentService;
    @GetMapping("/call-user-comment")
    public ResponseEntity<List<MovieComment>> findByUser_Name(String name){
        return ResponseEntity.ok(movieCommentService.findByUser_Name(name));
    }

    @GetMapping("/call-movie-comment")
    public ResponseEntity<List<MovieComment>> findByMovie_Name(String name){
        return ResponseEntity.ok(movieCommentService.findByMovie_Name(name));
    }
    @GetMapping("/call-movie-date")
    public ResponseEntity<List<MovieComment>> findByMovieandDate(String name, LocalDate firstDate,LocalDate lastDate){
        return ResponseEntity.ok(movieCommentService.findByMovieandDate(name,firstDate,lastDate));
    }

    @GetMapping("/call-user-date")
    public ResponseEntity<List<MovieComment>> findByUserandDate(String name, LocalDate firstDate,LocalDate lastDate){
        return ResponseEntity.ok(movieCommentService.findByUserandDate(name,firstDate,lastDate));
    }
    @GetMapping("/call-content")
    public ResponseEntity<List<MovieComment>> findAllByContent(String content){
        return ResponseEntity.ok(movieCommentService.findAllByContent(content));
    }

    @GetMapping("/call-size")
    public ResponseEntity<List<MovieComment>> findByContentLengthGreaterThan(int length){
        return ResponseEntity.ok(movieCommentService.findByContentLengthGreaterThan(length));
    }
}
