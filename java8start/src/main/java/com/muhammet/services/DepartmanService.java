package com.muhammet.services;

import com.muhammet.repository.IDepartmanRepository;
import com.muhammet.repository.entity.Departman;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmanService {
    /**
     * Spring te bir sınıfa  yada interface e referans atamanın yani new işlemi yaparak bir nesne oluşturmanın
     * 2 yolu vardır.
     * 1- @Autowired annotation ı ile
     * 2- Constructer injection ile, Spring boot context içinde yarattığı nesnelerin refranslarını
     * ihtiyacı olan sınıflara parametre olarak gönderir.
     */

    private final IDepartmanRepository repository;
    public DepartmanService(IDepartmanRepository repository){
        this.repository = repository;
    }
    public void save(Departman departman){
        repository.save(departman);
    }

    public List<Departman> findAll(){
        return repository.findAll();
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    /**
     * Bir yöneticinin bakmakta olduğu departmanlar nelerdir?
     *
     */
    public List<Departman> findByYoneticiId(Long id){
        return null;
    }

    public List<Departman> findAllKonumAdi(String ad){
        return repository.findAllByKonum(ad);
    }
}