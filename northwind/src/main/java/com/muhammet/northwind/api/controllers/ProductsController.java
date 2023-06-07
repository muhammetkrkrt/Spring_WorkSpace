package com.muhammet.northwind.api.controllers;

import com.muhammet.northwind.business.abstracts.ProductService;
import com.muhammet.northwind.entities.concretes.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/getall")
    public List<Product> getAll(){
        return productService.getAll();
    }
}
