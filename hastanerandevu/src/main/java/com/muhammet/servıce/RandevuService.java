package com.muhammet.servıce;

import com.muhammet.reposıtory.IHastaRepository;
import com.muhammet.reposıtory.IRandevuRepository;
import com.muhammet.reposıtory.entity.Randevu;
import com.muhammet.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class RandevuService extends ServiceManager<Randevu,Long> {

    private final IRandevuRepository repository;
    public RandevuService(IRandevuRepository repository){
        super(repository);
        this.repository=repository;
    }
}
