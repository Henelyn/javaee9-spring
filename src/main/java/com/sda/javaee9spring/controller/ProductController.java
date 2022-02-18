package com.sda.javaee9spring.controller;

import com.sda.javaee9spring.entityOrModel.ProductEntity;
import com.sda.javaee9spring.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/products")
public class ProductController {

private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ProductEntity findProductEntityById(@PathVariable("id") Long productId) { //@PathVariable will say where to find what we're looking for
        log.info("Trying to find person entity by id: [{}]", productId);

        return productService.readProductEntityById(productId);
    }

    @GetMapping("/")
    public List<ProductEntity> findAllProductEntities(){
        log.info("Trying to list all the products");

        return productService.readAllProductEntities();
    }
}
