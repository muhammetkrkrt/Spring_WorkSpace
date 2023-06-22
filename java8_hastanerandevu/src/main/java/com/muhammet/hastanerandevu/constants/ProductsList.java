package com.muhammet.hastanerandevu.constants;

import com.muhammet.hastanerandevu.repository.view.VwProduct;

import java.util.ArrayList;
import java.util.List;

public class ProductsList {

    public static List<VwProduct> getProductList(){
        List<VwProduct> result = new ArrayList<>();
        result.add(VwProduct.builder().status(true).productName("Laptop Asus").sales(123).stock(590).price(23999).build());
        result.add(VwProduct.builder().status(true).productName("Monitör HP").sales(3).stock(9).price(9580).build());
        result.add(VwProduct.builder().status(true).productName("Mouse&Keyboard Set").sales(4).stock(11).price(2500).build());
        result.add(VwProduct.builder().status(true).productName("Yazıcı").sales(55).stock(2458).price(890).build());
        result.add(VwProduct.builder().status(true).productName("Tarayıcı").sales(32).stock(60).price(660).build());
        result.add(VwProduct.builder().status(false).productName("Plotter").sales(89).stock(6).price(63500).build());
        result.add(VwProduct.builder().status(true).productName("PSU").sales(64).stock(900).price(1500).build());
        result.add(VwProduct.builder().status(true).productName("Ekran Kartı").sales(54).stock(504).price(65000).build());
        result.add(VwProduct.builder().status(true).productName("MotherBoard").sales(33).stock(100).price(3654).build());
        result.add(VwProduct.builder().status(true).productName("CPU").sales(22).stock(66).price(8871).build());
        return result;
    }
}
