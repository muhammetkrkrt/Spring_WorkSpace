package com.muhammet.services;

import com.muhammet.dto.request.SavePersonelRequestDto;
import com.muhammet.mapper.IPersonelMapper;
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

    public Boolean saveFromDto(SavePersonelRequestDto dto){
        Personel personel = IPersonelMapper.INSTANCE.personelFromDto(dto);
        repository.save(personel);
        return true;
    }
}