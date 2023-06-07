package com.muhammet.northwind.business.abstracts;

import com.muhammet.northwind.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
}
