package com.muhammet.hastanerandevu.repository.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VwDoktor {
    Long id;
    String ad;
    Long bransid;
}
