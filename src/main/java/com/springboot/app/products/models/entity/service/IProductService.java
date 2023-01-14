package com.springboot.app.products.models.entity.service;

import com.commons.springbootcommons.models.entity.Product;

import java.util.List;

public interface IProductService {


    List<Product> findAll();

    Product findById(Long id);

    Product save(Product product);

    void deleteById(Long id);



}
