package com.springboot.app.products.models.entity.controllers;

import com.commons.springbootcommons.models.entity.Product;
import com.springboot.app.products.models.entity.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    @Autowired
    private Environment env;

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private IProductService productService;

    @GetMapping("/list")
    public List<Product> list() {
        return productService.findAll().stream().map(product -> {
            product.setPort(Integer.valueOf(env.getProperty("local.server.port")));
//            product.setPort(port);
            return product;
        }).collect(Collectors.toList());
    }

    @GetMapping("/show/{id}")
    public Product detail(@PathVariable Long id) throws InterruptedException {
        if(id.equals(10L)) {
            throw new IllegalStateException("Product not found");
        }
        if(id.equals(7L))
            TimeUnit.SECONDS.sleep(3L);
        Product product = productService.findById(id);
        product.setPort(Integer.valueOf(env.getProperty("local.server.port")));
//        product.setPort(port);
        boolean ok = false;
//        try {
//            Thread.sleep(2000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return product;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product){
        return productService.save(product);
    }

    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Product edit(@RequestBody Product product,@PathVariable Long id){
        Product productDb = productService.findById(id);
        productDb.setNameProduct(product.getNameProduct());
        productDb.setPrice(product.getPrice());
        return productService.save(productDb);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        productService.deleteById(id);
    }
}
