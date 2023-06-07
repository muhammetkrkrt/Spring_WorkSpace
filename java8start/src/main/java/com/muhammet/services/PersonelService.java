package com.muhammet.services;

import com.muhammet.repository.IPersonelRepository;
import com.muhammet.repository.entity.Personel;
import com.muhammet.utility.ServiceManager;

import org.springframework.stereotype.Service;

@Service
public class PersonelService extends ServiceManager<Personel,Long> {
    private final IPersonelRepository repository;
    public PersonelService(IPersonelRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
