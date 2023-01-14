package com.springboot.app.products.models.entity.service;

import com.commons.springbootcommons.models.entity.Product;
import com.springboot.app.products.models.entity.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{


    private final ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return (List<Product>) productDao.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productDao.findById(id).orElse(null );
    }

    @Override
    @Transactional
    public Product save(Product product) {
        return productDao.save(product);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        productDao.deleteById(id);
    }
}
