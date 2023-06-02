package com.muhammet.controller;

import com.muhammet.repository.entity.Departman;
import com.muhammet.services.DepartmanService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/departman")
public class DepartmanController {

    private final DepartmanService departmanService;

    public DepartmanController(DepartmanService departmanService){
        this.departmanService=departmanService;
    }
    @GetMapping("/getall")
    public List<Departman> getAll(){
        return departmanService.findAll();
    }
    @GetMapping("/save")
    public void save(String ad,String konum){
        Departman departman = Departman.builder().ad(ad).konum(konum).build();
        departmanService.save(departman);
    }
    @GetMapping("/delete")
    public void delete(Long id){
        departmanService.delete(id);
    }
}
