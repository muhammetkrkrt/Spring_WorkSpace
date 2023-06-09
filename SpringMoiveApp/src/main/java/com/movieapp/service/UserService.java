package com.movieapp.service;

import com.movieapp.dto.request.UserRegisterRequestDto;
import com.movieapp.dto.response.UserFindAllResponseDto;
import com.movieapp.dto.response.UserRegisterResponseDto;
import com.movieapp.entity.Genre;
import com.movieapp.entity.User;
import com.movieapp.entity.UserType;
import com.movieapp.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository userRepository;

    public User createUser(String name, String surname, String email, String phone, String password, String userType) {
        UserType userType1 = null;
        User user;
        try {
            userType1 = UserType.valueOf(userType);
            user = User.builder()
                    .name(name)
                    .surname(surname)
                    .email(email)
                    .phone(phone)
                    .password(password)
                    .userType(userType1)
                    .build();
        }catch (Exception ex){
            System.out.println("Böyle bir userType bulunamadı");
            user = User.builder()
                    .name(name)
                    .surname(surname)
                    .email(email)
                    .phone(phone)
                    .password(password)
                    .build();
        }
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void saveAll(List<User> users) {
        userRepository.saveAll(users);
    }

    public List<User> findAllByOrderByName(){
        return userRepository.findAllByOrderByName();
    }

    public List<User> findByNameContaining(String search){
        return userRepository.findByNameContaining(search);
    }

    public List<User> findByEmailLike(String mail){
        return userRepository.findByEmailLike(mail);
    }


    public List<User> findAllByEmailEndsWith(String value) {
        return userRepository.findAllByEmailEndsWith(value);
    }

    public List<User> findAllByEmailEndingWith(String value) {
        return userRepository.findAllByEmailEndingWith(value);
    }

    public Boolean existsByEmailAndPassword(String mail,String password){
        return userRepository.existsByEmailAndPassword(mail,password);
    }
    public Optional<User> findByEmailAndPassword(String mail, String password){
        return userRepository.findByEmailAndPassword(mail,password);
    }


    public UserRegisterResponseDto register(UserRegisterRequestDto dto){
        User user = User.builder().name(dto.getName())
                .surname(dto.getSurname())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
        userRepository.save(user);
        return UserRegisterResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .userType(user.getUserType())
                .build();
    }


    public List<UserFindAllResponseDto> findAllResponseDto() {
        return userRepository.findAll().stream().map(x->{
            return UserFindAllResponseDto.builder()
                    .id(x.getId())
                    .name(x.getName())
                    .surname(x.getSurname())
                    .favGenres(x.getFavGenres())
                    .favMovie(x.getFavMovies())
                    .phone(x.getPhone())
                    .userType(x.getUserType())
                    .build();
        }).collect(Collectors.toList());

    }

}
