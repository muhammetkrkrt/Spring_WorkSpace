package com.muhammet.hastanerandevu.repository;

import com.muhammet.hastanerandevu.repository.entity.Brans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IBransRepository extends JpaRepository<Brans,Long> {

    /**
     * Bu değer var ise nesne gelecek yok ise null
     * bunun yerine ne kullanılabilir?
     *
     */
    Optional<Brans> findOptionalByAdIgnoreCase(String ad);
}
