package com.muhammet.hastanerandevu.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BransSaveRequestDto {

    @NotEmpty
    @Size(min = 2,max=20)
    String ad;
}
