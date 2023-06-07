package com.muhammet.northwind.business.concretes;

import com.muhammet.northwind.business.abstracts.ProductService;
import com.muhammet.northwind.dataAccess.abstracts.ProductDao;
import com.muhammet.northwind.entities.concretes.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    private final ProductDao productDao;

    public ProductManager(ProductDao productDao){
        this.productDao = productDao;
    }
    @Override
    public List<Product> getAll() {
        return productDao.findAll();
    }
}
