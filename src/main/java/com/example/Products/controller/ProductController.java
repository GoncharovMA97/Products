package com.example.Products.controller;

import com.example.Products.dto.ProductDTO;
import com.example.Products.entity.Product;
import com.example.Products.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> readAll() {
        return mappingResponseListProduct(productService.readAll());
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> readByCategoryId(@PathVariable Long id) {
        return mappingResponseListProduct(productService.readByCategoryId(id));
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDTO dto) {
        return mappingResponseProduct(productService.create(dto));
    }

    @PutMapping
    public ResponseEntity<Product> update(@RequestBody Product product) {
        return mappingResponseProduct(productService.update(product));
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        productService.delete(id);
        return HttpStatus.OK;
    }

    private ResponseEntity<Product> mappingResponseProduct(Product product) {
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    private ResponseEntity<List<Product>> mappingResponseListProduct(List<Product> products) {
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
