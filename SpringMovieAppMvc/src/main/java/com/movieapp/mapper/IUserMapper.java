package com.movieapp.mapper;

import com.movieapp.dto.request.UserRegisterRequestDto;
import com.movieapp.dto.response.UserLoginResponseDto;
import com.movieapp.dto.response.UserRegisterResponseDto;
import com.movieapp.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spirng", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {

    IUserMapper INSTANCE= Mappers.getMapper(IUserMapper.class);
    User toUser(UserRegisterRequestDto dto);

    UserRegisterResponseDto toRegisterResponseDto(final User user);

    UserLoginResponseDto toLoginResponseDto(User user);
}
