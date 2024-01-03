package com.example.express.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.example.express.Entity.Catalogue;
import com.example.express.Entity.Categorie;
import com.example.express.Entity.Livre;
import com.example.express.Repository.CatalogueRepository;
import com.example.express.Repository.LivreRepository;
import com.example.express.dto.CatalogueDto;




@Service
public class CatalogueServiceImpl implements CatalogueService{

         private CatalogueRepository catalogueRepository;
    private LivreRepository livreRepository;
    

    public CatalogueServiceImpl(CatalogueRepository catalogueRepository,
                           LivreRepository livreRepository) {
        this.catalogueRepository = catalogueRepository;
        this.livreRepository = livreRepository;
      
    }

    // fonctions


    // save catalogue
    @Override
    public void saveCat(CatalogueDto catalogueDto) {
        Catalogue catalogue = new Catalogue();
        catalogue.setNom(catalogueDto.getNom() );
        catalogue.setDescription(catalogueDto.getDescription());
       // livre
        List<Livre> livres = catalogueDto.getLivreId().stream()
        .map(LivreId -> livreRepository.findById(LivreId).orElse(null))
        .filter(Objects::nonNull)
        .collect(Collectors.toList());

            catalogue.setLivre(livres);
            catalogueRepository.save(catalogue);

    }
// catalogueDto
     @Override
    public CatalogueDto findByIdd(Long Id) {
        return null;
    }
// all catalogue 
@Override
        public List<CatalogueDto> findAllCatalogue() {
             List<Catalogue> catalogues = catalogueRepository.findAll();
            return catalogues.stream().map(this::convertEntityToDtoWithLivre).collect(Collectors.toList());
    }

    private CatalogueDto convertEntityToDtoWithLivre(Catalogue catalogue){
        CatalogueDto catalogueDto = convertEntityToDto(catalogue);

        // Populate livre names
        List<String> LivreTitre = catalogue.getLivre().stream()
        .map(Livre::getTitre)
        .collect(Collectors.toList());
        catalogueDto.setLivreTitre(LivreTitre);

        return catalogueDto;
    }

    private CatalogueDto convertEntityToDto(Catalogue catalogue){
        CatalogueDto catalogueDto = new CatalogueDto();
        catalogueDto.setId(catalogue.getId());
        catalogueDto.setNom(catalogue.getNom());
        catalogueDto.setDescription(catalogue.getDescription());
        
        return catalogueDto;
    }

@Override
    public Map<String, Long> getLivreStatistics() {
        List<Catalogue> allCatalogue = catalogueRepository.findAll();

        Map<String, Long> livreStatistics = new HashMap<>();

        
        for (Catalogue catalogue : allCatalogue) {
            for (Livre livre : catalogue.getLivre()) {
                livreStatistics.merge(livre.getTitre(), 1L, Long::sum);
            }
        }

        return livreStatistics;
    }


    @Override
    public Catalogue getCatalogueById(long id) {
    Optional < Catalogue > optional = catalogueRepository.findById(id);
    Catalogue catalogue = null;
    if (optional.isPresent()) {
        catalogue = optional.get();
    } else {
        throw new RuntimeException(" catalogue not found for id :: " + id);
    }
    return catalogue;
}



 //update catalogue
     @Override
    public void updateCat(Long id, CatalogueDto updat) {
        Catalogue catalogue = catalogueRepository.getCatalogueById(id);

        catalogue.setNom(updat.getNom());
        catalogue.setDescription(updat.getDescription());
        // Update livre
        System.out.println(livreRepository.findAllById(updat.getLivreId()));
        List<Livre> updatedLivres = null;
        if (updat.getLivreId() != null) {
            updatedLivres = livreRepository.findAllById(updat.getLivreId());
        }

        // Clear existing associations and add new ones
        catalogue.getLivre().clear();
        if (updatedLivres != null) {
            catalogue.getLivre().addAll(updatedLivres);
        }

        catalogueRepository.save(catalogue);

    }
    


    //delete catalogue
@Override
public void deleteCat(Long id) {
    Optional<Catalogue> catOptional = catalogueRepository.findById(id);

    if (catOptional.isPresent()) {
        Catalogue catalogue = catOptional.get();

        // Remove the book from categories to avoid cascading issues
        for (Livre livre : catalogue.getLivre()) {
            livre.getCatalogues().remove(catalogue);
        
        }

        // Clear the categories from the book
        catalogue.getLivre().clear();

        // Delete the book
        catalogueRepository.delete(catalogue);
    }
}
}