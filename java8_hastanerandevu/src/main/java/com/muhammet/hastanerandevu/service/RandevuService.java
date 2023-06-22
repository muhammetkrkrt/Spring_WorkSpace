package com.muhammet.hastanerandevu.service;

import com.muhammet.hastanerandevu.dto.request.RandevuSaveReqestDto;
import com.muhammet.hastanerandevu.exceptions.ErrorType;
import com.muhammet.hastanerandevu.exceptions.HastaneRandevuException;
import com.muhammet.hastanerandevu.repository.IRandevuRepository;
import com.muhammet.hastanerandevu.repository.entity.Randevu;
import com.muhammet.hastanerandevu.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class RandevuService extends ServiceManager<Randevu,Long> {

    private final DoktorService doktorService;
    private final HastaService hastaService;
    private final IRandevuRepository repository;
    /**
     * TODO: Bir servisin içinde başka bir sevisi kullanmak doğru mudur?
     * çağırım yapacağınız servis içinde özelleştirilmiş methodlar ve işlemler olabilir.
     * bu özel methodlar datayı manipüle ederken farklı işlemler yapabilir. işlemleri
     * soyutlama nedeniyle ilgili serviste yapılan işlemleri bilemeyeceğimiz için
     * direkt Repository e erişmek sakıncalı olacaktır.
     *
     * TODO: Ancak servisler bir birlerinie çağırarak loop yaratmamalıdır.
     */
    // private final IDoktorRepository doktorRepository;

    public RandevuService(IRandevuRepository repository,
                          DoktorService doktorService,
                          HastaService hastaService){
        super(repository);
        this.doktorService = doktorService;
        this.hastaService = hastaService;
        this.repository = repository;
    }

    public Randevu save(RandevuSaveReqestDto dto){
        /**
         * TODO: Doktor id konrtol edelim yok ise hata döndürelim
         * TODO: Hasta id kontrol edelim yok ise hata döndürelim
         * TODO: Tarih kontrol edelim mevcut zamandan önce ise hata döndürelim
         */
        if(doktorService.findById(dto.getDoktorid()).isEmpty()) // dto içinden gelen doktor id doktor tablosunda yok ise, hata fırlat
            throw new HastaneRandevuException(ErrorType.DOKTOR_BULUNAMADI);
        else if(hastaService.findById(dto.getHastaid()).isEmpty())
            throw new HastaneRandevuException(ErrorType.HASTA_BULUNAMADI);
        /**
         * TODO: ÖDEV Randevu tarihleri Long olarak geldiği için kontrol edilmesi kolay olacaktır.
         * ancak eğer tarihler şöyle iletilse idi nasıl yapılabilirdi?
         * Yıl,Ay,Gün,Saat,Dakika  ???????
         */
        return null;
    }

}
