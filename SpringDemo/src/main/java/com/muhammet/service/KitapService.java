package com.muhammet.service;

import com.muhammet.entity.Kitap;
import com.muhammet.repository.IKitapRepository;
import org.springframework.stereotype.Service;

@Service
public class KitapService {

    private final IKitapRepository repository;
    public KitapService(IKitapRepository repository){
        this.repository=repository;
    }


    public void save(Kitap kitap) {
        repository.save(kitap);
    }
}
