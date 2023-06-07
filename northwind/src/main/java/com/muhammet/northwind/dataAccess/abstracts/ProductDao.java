package com.muhammet.northwind.dataAccess.abstracts;

import com.muhammet.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Long> {

}
