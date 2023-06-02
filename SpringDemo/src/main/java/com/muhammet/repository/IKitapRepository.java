package com.muhammet.repository;

import com.muhammet.entity.Kitap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IKitapRepository extends JpaRepository<Kitap,Long> {

}
