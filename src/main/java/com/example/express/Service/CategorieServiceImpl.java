package com.example.express.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.express.Entity.Categorie;
import com.example.express.Repository.CategorieRepository;

public class CategorieServiceImpl {
    @Autowired
    private CategorieRepository categorieRepository;

    // Other methods...

    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    


    
}
