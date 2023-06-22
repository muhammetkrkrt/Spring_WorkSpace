package com.muhammet.hastanerandevu.service;

import com.muhammet.hastanerandevu.dto.request.DoktorSaveRequestDto;
import com.muhammet.hastanerandevu.mapper.IDoktorMapper;
import com.muhammet.hastanerandevu.repository.IDoktorRepository;
import com.muhammet.hastanerandevu.repository.entity.Doktor;
import com.muhammet.hastanerandevu.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoktorService extends ServiceManager<Doktor,Long> {
    private final IDoktorRepository repository;

    public DoktorService(IDoktorRepository repository){
        super(repository);
        this.repository = repository;
    }
    public Doktor save(DoktorSaveRequestDto dto){
        /**
         * Dikkat Burada ek neler yapılabilir?
         * 1- Doktorların özel olan bilgileri kontrol edilerek mükerrer kayıt yapılmasının önüne geçilebilir
         * 2- bransid benzersiz ve tutarlı olduğu için kontrol edilebilir. bransid yok ise kayıt işlemi
         * hata fırlatabilir.
         */
        Doktor doktor = IDoktorMapper.INSTANCE.fromSaveDto(dto);
        return repository.save(doktor);
    }

    public List<Doktor> findByAd(String ad){
        return repository.findAllByAdContaining(ad);
    }
}
