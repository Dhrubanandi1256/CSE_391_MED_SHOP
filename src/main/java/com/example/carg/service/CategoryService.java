package com.example.carg.service;

import com.example.carg.model.Category;
import com.example.carg.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    //Retrive
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }
    //save method
    public void addCategory(Category category){
        categoryRepository.save(category);
    }
    public void removecategoryById(int id){
        categoryRepository.deleteById(id);

    }

    public Optional<Category> getCategoryById(int id){
        return categoryRepository.findById(id);
    }
}


