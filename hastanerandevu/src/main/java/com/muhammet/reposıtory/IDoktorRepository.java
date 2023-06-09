package com.muhammet.reposıtory;

import com.muhammet.reposıtory.entity.Doktor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDoktorRepository extends JpaRepository<Doktor,Long> {
}
