package com.muhammet.hastanerandevu.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DoktorResponseDto {
    Long id;
    String ad;
    Long bransid;
    String bransad;
}
