package com.muhammet.repository.view;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
public class VwDepartmanList {
    Long id;
    String ad;

    public VwDepartmanList(Long id , String ad){
        this.ad=ad;
        this.id=id;
    }
}
