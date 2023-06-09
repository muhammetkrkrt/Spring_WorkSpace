package com.muhammet.reposıtory;

import com.muhammet.reposıtory.entity.Randevu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRandevuRepository extends JpaRepository<Randevu,Long> {
}
