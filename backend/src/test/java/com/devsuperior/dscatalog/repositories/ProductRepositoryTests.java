package com.devsuperior.dscatalog.repositories;

import com.devsuperior.dscatalog.entities.Product;
import com.devsuperior.dscatalog.tests.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository repository;

    private long existingId;
    private long nonExistingId;
    private long countTotalProducts;

    @BeforeEach
    void setUp() throws Exception {
        existingId = 2L;
        nonExistingId = 1000L;
        countTotalProducts = 8;
    }
    @Test
    public void saveShouldPersistWithAutoInclementWhenIdIsNull(){
        Product product = Factory.createProduct();
        product.setId(null);

        product = repository.save(product);

        Assertions.assertNotNull(product.getId());
        Assertions.assertNotNull(product.getId());

    }
    @Test
    public void deleteShouldDeleteObjectWhenIdExists() {

        repository.deleteById(existingId);

        Optional<Product> result = repository.findById(existingId);
        Assertions.assertFalse(result.isPresent());
    }


    @Test
    public void findByIDShouldReturnNomEmptyOptionalWhenIdExists(){

        Optional<Product> result = repository.findById(existingId);

        Assertions.assertTrue(result.isPresent());
    }
    @Test
    public void findByIDShouldReturnEmptyOptionalWhenIdDoesNotExists(){

        Optional<Product> result = repository.findById(nonExistingId);

        Assertions.assertTrue(result.isEmpty());
    }



}
