package com.zoletrafael.productsapi.repository;

import com.zoletrafael.productsapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interface for querying and persisting product data.
 */
public interface ProductRepository extends JpaRepository<Product, String> {

    /**
     * Finds products by name.
     * @param name
     * @return products matching the given name
     */
    List<Product> findByName(String name);
}