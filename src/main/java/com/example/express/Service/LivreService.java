package com.example.express.Service;

import java.util.List;
import java.util.Map;

import com.example.express.Entity.Livre;
import com.example.express.dto.LivreDto;

public interface LivreService {

// save livre 
    void saveLivre(LivreDto livreDto);

  

   
    LivreDto findByIdd(Long Id);

     List<LivreDto> findAllLivre();
    
 

    
     Livre getLivreById(long id);
   

    Map<String, Long> getCategoryStatistics();

    public void deleteLivre(Long id);

    


    void updateBook(Long id, LivreDto livreDto);

   
   
  
}
