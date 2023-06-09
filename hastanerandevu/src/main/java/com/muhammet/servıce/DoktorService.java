package com.muhammet.servıce;

import com.muhammet.reposıtory.IDoktorRepository;
import com.muhammet.reposıtory.IHastaRepository;
import com.muhammet.reposıtory.entity.Doktor;
import com.muhammet.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class DoktorService extends ServiceManager<Doktor,Long> {

    private IDoktorRepository repository;

    public DoktorService(IDoktorRepository repository){
        super(repository);
        this.repository=repository;
    }
}
