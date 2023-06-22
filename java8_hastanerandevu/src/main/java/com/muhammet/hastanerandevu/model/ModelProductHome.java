package com.muhammet.hastanerandevu.model;

import com.muhammet.hastanerandevu.repository.view.VwProduct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ModelProductHome {
    /**
     * sol menüdeki liste bilgilerine
     * ürünlerin listesine
     * başlığa
     * v.s.
     */
    List<String> menuList;
    String title;
    Long userId;
    String userName;
    String userImage;
    List<VwProduct> urunListesi;
}
