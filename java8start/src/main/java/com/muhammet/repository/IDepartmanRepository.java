package com.muhammet.repository;

import com.muhammet.repository.entity.Departman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDepartmanRepository extends JpaRepository<Departman,Long> {

    List<Departman> findByYoneticiid (Long id);
    List<Departman> findAllByKonum(String ad);

    Departman findByAd(String ad);

    /*
     *Aradigim kelime departman adi icinde var ise bunlarin listesini getirsin
     */

    List<Departman> findByAdLike(String searchKey);
}
