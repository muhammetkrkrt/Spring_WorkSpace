package com.muhammet.controller;

import com.muhammet.repository.entity.Departman;
import com.muhammet.services.DepartmanService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller katmanında 2 kullanım şeklmiz var web için
 * 1- @Controller annotation ı ile MVC odaklı programlama
 * 2- @RestController annotation ı ile Restful web servisler
 */
@RestController
/**
 * http://localhost:9090/departman
 */
@RequestMapping("/departman")
public class DepartmanController {
    private final DepartmanService departmanService;
    public DepartmanController(DepartmanService departmanService){
        this.departmanService = departmanService;
    }
    /***
     * GetMapping -> isteği get türünde olduğunu belirtir. sadece get isteklerini karşılar.
     * http://localhost:9090/departman/getall
     * @return
     */
    @GetMapping("/getall") // PostMapping, PutMapping, DeleteMapping, PatchMapping
    @CrossOrigin("*")
    public List<Departman> getAll(){
        return departmanService.findAll();
    }

    /**
     * http://localhost:9090/departman/save?ad=IT&konum=Istanbul
     * @param ad
     * @param konum
     */
    @GetMapping("/save")
    @CrossOrigin("*")
    public void save(String ad, String konum){
        Departman departman = Departman.builder().ad(ad).konum(konum).build();
        departmanService.save(departman);
    }

    /**
     * http://localhost:9090/departman/delete?id=7
     * @param id
     */
    @GetMapping("/delete")
    @CrossOrigin("*")
    public void delete(Long id){
        departmanService.delete(id);
    }

    @GetMapping("/findkonum")
    public List<Departman> findByKonum(String ad){
        return departmanService.findAllKonumAdi(ad);
    }

}