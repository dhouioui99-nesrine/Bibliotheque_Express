package com.example.express.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.express.Entity.Categorie;


public interface CategorieRepository extends JpaRepository<Categorie, Long> {

    
}
