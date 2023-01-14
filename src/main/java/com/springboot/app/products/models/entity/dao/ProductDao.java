package com.springboot.app.products.models.entity.dao;

import com.commons.springbootcommons.models.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends CrudRepository<Product,Long> {


}
