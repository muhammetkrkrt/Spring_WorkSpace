package com.muhammet.hastanerandevu.repository;

import com.muhammet.hastanerandevu.repository.entity.Doktor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDoktorRepository extends JpaRepository<Doktor,Long> {
    /**
     * Bu method ad parametresine göre doktorları getirir, ancak adı aynı olan doktorları getirir.
     * @param ad
     * @return
     */
    List<Doktor> findAllByAd(String ad);

    /**
     * Ad bilsi tam girilmemiş ise bile kısmi girişler ile ad alanında arama yaparak
     * uyuşan tüm kayıtları listelemek için kullanılır.
     */
    List<Doktor> findAllByAdContaining(String ad);
}
