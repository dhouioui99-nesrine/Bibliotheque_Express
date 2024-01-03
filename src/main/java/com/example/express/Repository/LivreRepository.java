package com.example.express.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
   
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import com.example.express.Entity.Livre;


@EnableJpaRepositories
public interface LivreRepository extends JpaRepository<Livre, Long> {
    
    void deleteById(Long id);

    Livre getLivreById(Long id);

    Livre findByTitre(String titre);

   
}