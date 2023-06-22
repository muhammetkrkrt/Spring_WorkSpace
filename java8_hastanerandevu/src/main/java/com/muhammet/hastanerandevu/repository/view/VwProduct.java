package com.muhammet.hastanerandevu.repository.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VwProduct {
    String productImage;
    String productName;
    String category;
    boolean status;
    Integer sales;
    Integer stock;
    Integer price;

}
