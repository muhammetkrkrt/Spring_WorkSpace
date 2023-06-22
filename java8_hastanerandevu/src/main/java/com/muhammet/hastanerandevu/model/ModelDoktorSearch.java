package com.muhammet.hastanerandevu.model;

import com.muhammet.hastanerandevu.repository.entity.Doktor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ModelDoktorSearch {

    List<Doktor> doktorList;
}
