package com.muhammet.hastanerandevu.repository;

import com.muhammet.hastanerandevu.repository.entity.Hasta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHastaRepository extends JpaRepository<Hasta,Long> {
}
