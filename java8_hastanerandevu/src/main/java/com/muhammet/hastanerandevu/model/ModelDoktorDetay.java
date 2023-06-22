package com.muhammet.hastanerandevu.model;

import com.muhammet.hastanerandevu.repository.entity.Doktor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ModelDoktorDetay {

    Doktor doktor;

}
