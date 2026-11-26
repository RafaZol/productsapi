package com.zoletrafael.productsapi.controller;

import com.zoletrafael.productsapi.model.Product;
import com.zoletrafael.productsapi.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Controller that handles HTTP requests and delegates to the repository.
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    /**
     * Repository for querying and persisting product data.
     */
    private ProductRepository repository;

    /**
     * Creates a product controller.
     * @param repository
     */
    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    /**
     * Saves a product to the database.
     * @param p
     * @return the saved product
     */
    @PostMapping
    public Product save(@RequestBody Product p){
        var id = UUID.randomUUID().toString();
        p.setId(id);
        return repository.save(p);
    }

    /**
     * Updates a product in the database.
     * @param id
     * @param p the product data to update
     */
    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody Product p){
        p.setId(id);
        repository.save(p);
    }

    /**
     * Deletes a product from the database.
     * @param id
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        repository.deleteById(id);
    }

    /**
     * Finds a product by ID in the database.
     * @param id
     * @return the matching product, or {@code null} if none is found
     */
    @GetMapping("/{id}")
    public Product findById(@PathVariable String id){
        return repository.findById(id).orElse(null);
    }

    /**
     * Finds products by name in the database.
     * @param name
     * @return products matching the given name
     */
    @GetMapping
    public List<Product> findByName(@RequestParam("name") String name){
        return repository.findByName(name);
    }

}
