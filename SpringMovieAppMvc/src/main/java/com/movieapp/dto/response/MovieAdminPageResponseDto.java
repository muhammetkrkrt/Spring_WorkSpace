package com.movieapp.dto.response;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MovieAdminPageResponseDto {

    private Long id;
    private String language;
    private String name;
    private LocalDate premiered;
}
