package com.movieapp.dto.response;

import com.movieapp.entity.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegisterResponseDto {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private UserType userType;

}
