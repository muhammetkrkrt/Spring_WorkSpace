package com.movieapp.service;


import com.movieapp.dto.request.FavMovieRequestDto;
import com.movieapp.dto.request.UserLoginRequestDto;
import com.movieapp.dto.request.UserRegisterRequestDto;
import com.movieapp.dto.response.UserLoginResponseDto;
import com.movieapp.dto.response.UserRegisterResponseDto;
import com.movieapp.entity.Movie;
import com.movieapp.entity.User;
import com.movieapp.entity.UserType;
import com.movieapp.mapper.IUserMapper;
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
    private final MovieService movieService;

    public UserRegisterResponseDto save(UserRegisterRequestDto dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Bu email Zaten Kullanılıyor");
        } else {
            if (!dto.getPassword().equals(dto.getRePassword())) {
                throw new RuntimeException("Passwordler uyuşmuyor");
            }
            User user = IUserMapper.INSTANCE.toUser(dto);
            userRepository.save(user);
            return IUserMapper.INSTANCE.toRegisterResponseDto(user);
        }
    }

    public UserLoginResponseDto login(UserLoginRequestDto dto) {
        Optional<User> optionalUser = userRepository.findByEmailIgnoreCaseAndPassword(dto.getEmail(), dto.getPassword());

        if (optionalUser.isEmpty()) {
            throw new RuntimeException("Girdiğiniz bilgiler Uyuşmamaktadır");
        } else {
            User user = optionalUser.get();
            return IUserMapper.INSTANCE.toLoginResponseDto(user);
        }
    }

    public void saveAll(List<User> users) {
        userRepository.saveAll(users);
    }

    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }

    public void addFavmovies(FavMovieRequestDto dto) {
        Optional<User> optionalUser = userRepository.findById(dto.getUserId());
        Movie movie = movieService.findbyId(dto.getMovieId());
        if(optionalUser.isPresent()){
            if(!optionalUser.get().getFavMovies().contains(movie)){
                optionalUser.get().getFavMovies().add(movie);
                userRepository.save(optionalUser.get());
            }
        }else {
            throw new RuntimeException("Kullanıcı Bulunamadı");
        }
    }
    public void removeFavmovies(FavMovieRequestDto dto) {
        Optional<User> optionalUser = userRepository.findById(dto.getUserId());
        Movie movie = movieService.findbyId(dto.getMovieId());
        if(optionalUser.isPresent()){
            if(optionalUser.get().getFavMovies().contains(movie)){
                optionalUser.get().getFavMovies().remove(movie);
                userRepository.save(optionalUser.get());
            }
        }else {
            throw new RuntimeException("Kullanıcı Bulunamadı");
        }
    }

    public List<User> findAllUser() {
        return userRepository.findAll().stream().filter(x->!x.getUserType().equals(UserType.ADMIN)).collect(Collectors.toList());
    }
}
