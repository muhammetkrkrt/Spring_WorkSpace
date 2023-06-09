package com.muhammet.reposıtory;

import com.muhammet.reposıtory.entity.Brans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBransRepository extends JpaRepository<Brans,Long> {
}
