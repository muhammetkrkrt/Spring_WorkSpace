package com.movieapp.controller;

import com.movieapp.dto.request.UserRegisterRequestDto;
import com.movieapp.dto.response.UserFindAllResponseDto;
import com.movieapp.dto.response.UserRegisterResponseDto;
import com.movieapp.entity.User;
import com.movieapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public UserRegisterResponseDto createUser(UserRegisterRequestDto dto){
        return userService.register(dto);
    }
    @GetMapping("/create")
    public User createUser(String name, String surname, String email, String phone, String password, String userType){
        return userService.createUser(name,surname,email,phone,password,userType);
    }

    @GetMapping("/findall")
    public List<UserFindAllResponseDto> findAll(){
        return userService.findAllResponseDto();
    }
    @GetMapping("/findall")
    public List<User> createUser(){
        return userService.findAll();
    }
    @GetMapping("/orderbyname")
    public ResponseEntity<List<User>> findAllByOrderByName(){
        return ResponseEntity.ok(userService.findAllByOrderByName());
    }
    @GetMapping("/namecon")
    public ResponseEntity<List<User>> findByNameContaining(String search){
        return  ResponseEntity.ok(userService.findByNameContaining(search));
    }
    @GetMapping("/namelike")
    public ResponseEntity<List<User>> findByEmailLike(String mail){
        return ResponseEntity.ok(userService.findByEmailLike("%"+mail+"%"));
    }
    @GetMapping("/endswith")
    public ResponseEntity<List<User>> findAllByEmailEndsWith(String value){
        return ResponseEntity.ok(userService.findAllByEmailEndsWith(value));
    }
    //Rest Best Practice
    //Restful api Naming convencion best practice
    @GetMapping("/endingwith")
    public ResponseEntity<List<User>> findAllByEmailEndingWith(String value){
        return ResponseEntity.ok(userService.findAllByEmailEndingWith(value));
    }
    @GetMapping("/login")
    public ResponseEntity<Boolean> existsByEmailAndPassword(String mail,String password){
        return ResponseEntity.ok(userService.existsByEmailAndPassword(mail,password));
    }
    @GetMapping("/login2")
    public ResponseEntity<Optional<User>> findByEmailAndPassword(String mail,String password){
        return ResponseEntity.ok(userService.findByEmailAndPassword(mail,password));
    }
}
