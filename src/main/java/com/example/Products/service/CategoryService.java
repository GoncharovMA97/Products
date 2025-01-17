package com.example.Products.service;

import com.example.Products.entity.Category;
import com.example.Products.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> readAll() {
        return  categoryRepository.findAll();
    }

    public Category readById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Category not fond by id -" + id));
    }
}
