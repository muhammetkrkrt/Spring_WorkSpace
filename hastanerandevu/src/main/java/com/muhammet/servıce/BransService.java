package com.muhammet.servıce;

import com.muhammet.reposıtory.IBransRepository;
import com.muhammet.reposıtory.IHastaRepository;
import com.muhammet.reposıtory.entity.Brans;
import com.muhammet.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class BransService extends ServiceManager<Brans,Long> {

    private final IBransRepository repository;
    public BransService(IBransRepository repository){
        super(repository);
        this.repository=repository;
    }
}
