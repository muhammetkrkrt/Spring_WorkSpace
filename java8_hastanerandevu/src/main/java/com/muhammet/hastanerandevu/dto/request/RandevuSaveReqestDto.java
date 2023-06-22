package com.muhammet.hastanerandevu.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RandevuSaveReqestDto {
    @NotNull
    Long doktorid;
    @NotNull
    Long hastaid;
    @NotNull
    Long tarih; // 09.06.2023 - 10:30
    @NotNull
    Long zaman; // 10:30

    Integer gun;
    Integer ay;
    Integer yil;
    Integer saat;
    Integer dakika;

}
