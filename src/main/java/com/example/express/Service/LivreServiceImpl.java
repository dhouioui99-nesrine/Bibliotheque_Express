package com.example.express.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.express.Entity.Categorie;
import com.example.express.Entity.Livre;
import com.example.express.Repository.CategorieRepository;
import com.example.express.Repository.LivreRepository;
import com.example.express.dto.LivreDto;




@Service
public class LivreServiceImpl  implements LivreService{

        private LivreRepository livrerepo;
    private CategorieRepository categorierepo;
    

    public LivreServiceImpl(LivreRepository livrerepo,
                           CategorieRepository categorierepo) {
        this.livrerepo = livrerepo;
        this.categorierepo = categorierepo;
      
    }




//save livre 
    @Override
    public void saveLivre(LivreDto livreDto) {
        Livre livre = new Livre();
        livre.setTitre(livreDto.getTitre()); 
        livre.setAuteur(livreDto.getAuteur());
        livre.setDate_pub(livreDto.getDate_pub());
        livre.setNum_ESRN(livreDto.getNum_ESRN());
        livre.setExemplaire(livreDto.getExemplaire());

        List<Categorie> categories = livreDto.getCategorieIds().stream()
        .map(categoryId -> categorierepo.findById(categoryId).orElse(null))
        .filter(Objects::nonNull)
        .collect(Collectors.toList());

            livre.setCategories(categories);
            livrerepo.save(livre);
}
/* 
    @Override
    public Livre findById(Long id) {
        Livre livre = livrerepo.findId(id);
        return livre;
    }

*/
    @Override
    public LivreDto findByIdd(Long Id) {
        return null;
    }



// all livre
    @Override
public List<LivreDto> findAllLivre() {
        List<Livre> livres = livrerepo.findAll();
        return livres.stream().map(this::convertEntityToDtoWithCategorieNames).collect(Collectors.toList());
    }

    private LivreDto convertEntityToDtoWithCategorieNames(Livre livre){
        LivreDto livreDto = convertEntityToDto(livre);

        // Populate categorie names
        List<String> categorieNames = livre.getCategories().stream()
        .map(Categorie::getName)
        .collect(Collectors.toList());
        livreDto.setCategorieNames(categorieNames);

        return livreDto;
    }

    private LivreDto convertEntityToDto(Livre livre){
        LivreDto livreDto = new LivreDto();
        livreDto.setId(livre.getId());
        livreDto.setTitre(livre.getTitre());
        livreDto.setAuteur(livre.getAuteur());
        livreDto.setDate_pub(livre.getDate_pub());
         livreDto.setNum_ESRN(livre.getNum_ESRN());
        livreDto.setExemplaire(livre.getExemplaire());
        return livreDto;
    }

  
// autre function 

@Override
public void deleteLivre(Long id) {
    Optional<Livre> livreOptional = livrerepo.findById(id);

    if (livreOptional.isPresent()) {
        Livre livre = livreOptional.get();

        // Remove the book from categories to avoid cascading issues
        for (Categorie categorie : livre.getCategories()) {
            categorie.getLivres().remove(livre);
        }

        // Clear the categories from the book
        livre.getCategories().clear();

        // Delete the book
        livrerepo.delete(livre);
    }
}

    @Override
    public Map<String, Long> getCategoryStatistics() {
        List<Livre> allBooks = livrerepo.findAll();

        Map<String, Long> categoryStatistics = new HashMap<>();

        // Count books for each category
        for (Livre livre : allBooks) {
            for (Categorie categorie : livre.getCategories()) {
                categoryStatistics.merge(categorie.getName(), 1L, Long::sum);
            }
        }

        return categoryStatistics;
    }


   
     @Override
    public void updateBook(Long id, LivreDto updatedBook) {
        Livre livre = livrerepo.getLivreById(id);

        livre.setTitre(updatedBook.getTitre());
        livre.setAuteur(updatedBook.getAuteur());
        livre.setNum_ESRN(updatedBook.getNum_ESRN());
        livre.setDate_pub(updatedBook.getDate_pub());
        livre.setExemplaire(updatedBook.getExemplaire());
     
        // Update categories
        System.out.println(categorierepo.findAllById(updatedBook.getCategorieIds()));
        List<Categorie> updatedCategories = null;
        if (updatedBook.getCategorieIds() != null) {
            updatedCategories = categorierepo.findAllById(updatedBook.getCategorieIds());
        }

        // Clear existing associations and add new ones
        livre.getCategories().clear();
        if (updatedCategories != null) {
            livre.getCategories().addAll(updatedCategories);
        }

        livrerepo.save(livre);

    }


    

    @Override
public Livre getLivreById(long id) {
    Optional < Livre > optional = livrerepo.findById(id);
    Livre livre = null;
    if (optional.isPresent()) {
        livre = optional.get();
    } else {
        throw new RuntimeException(" livre not found for id :: " + id);
    }
    return livre;
}
   
}