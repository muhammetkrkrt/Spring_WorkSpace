package com.muhammet.services;

import com.muhammet.repository.IPersonelDepartmanRepository;
import com.muhammet.repository.entity.PersonelDepartman;
import com.muhammet.utility.ServiceManager;

import org.springframework.stereotype.Service;



@Service
public class PersonelDepartmanService extends ServiceManager<PersonelDepartman,Long> {
    private final IPersonelDepartmanRepository repository;
    public PersonelDepartmanService(IPersonelDepartmanRepository repository) {
        super(repository);
        this.repository = repository;
    }

}
