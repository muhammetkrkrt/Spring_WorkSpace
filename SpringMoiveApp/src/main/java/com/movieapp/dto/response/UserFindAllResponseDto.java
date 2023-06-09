package com.movieapp.dto.response;

import com.movieapp.entity.Genre;
import com.movieapp.entity.Movie;
import com.movieapp.entity.UserType;
import jdk.dynalink.linker.LinkerServices;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserFindAllResponseDto {

    private Long id;
    private String name;
    private String email;
    private String surname;
    private String phone;
    private UserType userType;
    private List<Movie> favMovie;
    private List<Genre> favGenres;

}
