package com.muhammet.services;

import com.muhammet.repository.IDepartmanRepository;
import com.muhammet.repository.entity.Departman;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmanService {


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

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
