package com.jayklef.Library.service;

import com.jayklef.Library.entity.Category;
import com.jayklef.Library.entity.Publisher;
import com.jayklef.Library.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    public List<Category> findAllCategories(){
        return categoryRepository.findAll();
    }

    public void updateCategory(Category category){
        categoryRepository.save(category);
    }

    public Category findCategory(Long id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category with id: " + id + "not found"));
        return category;
    }

    public void deleteCategory(Long id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category with id: " + id + "not found"));
        categoryRepository.deleteById(category.getId());
    }
}
