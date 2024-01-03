package com.example.express.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.express.Entity.Catalogue;




public interface CatalogueRepository extends JpaRepository<Catalogue, Long>{
    

    Catalogue findByNom(String nom);

     Catalogue getCatalogueById(Long id);
}
