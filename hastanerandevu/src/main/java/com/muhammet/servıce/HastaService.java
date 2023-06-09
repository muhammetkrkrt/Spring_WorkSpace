package com.muhammet.servıce;

import com.muhammet.reposıtory.IHastaRepository;
import com.muhammet.reposıtory.entity.Hasta;
import com.muhammet.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class HastaService extends ServiceManager<Hasta,Long> {

    private final IHastaRepository repository;

    public HastaService(IHastaRepository repository){
        super(repository);
        this.repository=repository;
    }

}
