package com.muhammet.controller;

import com.muhammet.entity.Kitap;
import com.muhammet.service.KitapService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kitap")
public class KitapController {

    private final KitapService kitapService;

    public KitapController(KitapService kitapService){
        this.kitapService=kitapService;
    }
    @GetMapping("/savekitap")
    public void saveKitap(String baslik,String yazar,int sayfaSayisi){
        Kitap kitap = Kitap.builder().baslik(baslik).yazarIsmi(yazar).sayfaSayisi(sayfaSayisi).build();
        kitapService.save(kitap);
    }
}
