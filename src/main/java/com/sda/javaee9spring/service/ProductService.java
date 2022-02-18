package com.sda.javaee9spring.service;

import com.sda.javaee9spring.entityOrModel.ProductEntity;
import com.sda.javaee9spring.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductEntity> readAllProductEntities() {
        log.info("Trying to read all product entities");

        var result = productRepository.findAll();
        for (ProductEntity product : result) {
            addVat(product);

        }
        log.info("product entities read from db: {}, result", result);
        return result;
    }

    public ProductEntity readProductEntityById(Long id) {
        log.info("trying to read entity by id: [{}]", id);


        var maybeProduct = productRepository.findById(id);
        ProductEntity result = null;
        if (maybeProduct.isPresent()) { //kontrollib kas vastus saadi
            result = maybeProduct.get(); // väärtusab tulemuse vastusega
            addVat(result); //lisab saadud tulemuse hinnale %
        }

        log.info("found person entity: [{}]", result);
        return result;
    }

    private void addVat(ProductEntity product){
        product.setPrice(product.getPrice() * 1.23);
    }
}
