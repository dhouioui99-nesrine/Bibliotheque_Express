package com.example.express.Service;

import java.util.List;
import java.util.Map;

import com.example.express.Entity.Catalogue;
import com.example.express.dto.CatalogueDto;



public interface CatalogueService {

    void saveCat(CatalogueDto catalogueDto);

    List<CatalogueDto> findAllCatalogue();
   
    Catalogue getCatalogueById(long id);
    
    Map<String, Long> getLivreStatistics();

    CatalogueDto findByIdd(Long Id);

// update 
    void updateCat(Long id, CatalogueDto updat);

// delete 
        void deleteCat(Long id) ;
}
