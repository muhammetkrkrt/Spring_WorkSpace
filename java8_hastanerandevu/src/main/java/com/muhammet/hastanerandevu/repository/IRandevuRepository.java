package com.muhammet.hastanerandevu.repository;

import com.muhammet.hastanerandevu.repository.entity.Randevu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRandevuRepository extends JpaRepository<Randevu,Long> {
}
