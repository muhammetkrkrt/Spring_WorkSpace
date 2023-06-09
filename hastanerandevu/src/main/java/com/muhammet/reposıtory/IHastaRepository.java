package com.muhammet.reposıtory;

import com.muhammet.reposıtory.entity.Hasta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHastaRepository extends JpaRepository<Hasta,Long> {
}
