package com.muhammet.mapper;

import com.muhammet.dto.reponse.FindAllVwUserResponseDto;
import com.muhammet.dto.request.SavePersonelRequestDto;
import com.muhammet.repository.entity.Personel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * Bir inteface in mapper işlemi yapabilmesi için @Mapper annotation ı kullanılmalıdır.
 * burada tanımlama yaparken kullanılan componentModel = "spring" ile spring tarafından yönetilen
 * bean yapısının entegre edileceğini belirtiyoruz.
 * İkinci önemli kısım ise mapping işleminde kaynak ile hedefin uyuşmayan alanlarının nasıl davranacağını
 * belirtiyoruz. en nihayetinde iki alan birebir biririne karşılık gelmeyebilir. Bu nedenle uyuşmayan alanlar
 * hata fırlatacaktır. Bu nedenle uyuşmazlıkları ignore ediyoruz. Böylece hata fırlatmadan işlemi gerçekleştirebiliriz.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IPersonelMapper {

    /**
     * Burası bizim interface imizden bir nesne yaratılarak referansının atanmsını sağlıyor.
     * böylece bizde bu nesneyi kullanarak mapping işlemlerini gerçekleştirebiliriz.
     */
    IPersonelMapper INSTANCE = Mappers.getMapper(IPersonelMapper.class);

    /**
     * Artık buradan itibaren gerekli kurulumlar bittiğinden dolayı dönüşüm için gerekli method tanımlamaları
     * yapılıyor.
     */
    /**
     * Geri dönüş tipi olarak sınıfı veriyoruz.
     * method atını sitediğiniz gibi yazabilirsiniz. amaca hizmet etsin anlaşılsın yeter
     * parametre olarak ise dto muzu veriyoruz.
     * [References Data Type] [method name] ([Parameter])
     *     target                              source
     */
    @Mapping(source = "memberdate", target= "giristarihi")
    Personel personelFromDto(final SavePersonelRequestDto dto);

    FindAllVwUserResponseDto personelToDto(final Personel personel);
}
