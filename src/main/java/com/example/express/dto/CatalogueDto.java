package com.example.express.dto;

import java.util.List;


import jakarta.validation.constraints.NotEmpty;

public class CatalogueDto {
      private Long id;
    @NotEmpty
    private String nom;
    @NotEmpty
    private String description;


    private List<Long> LivreId;
    private List<String> LivreTitre;




    
    public CatalogueDto() {
    }


    
    public CatalogueDto(Long id, @NotEmpty String nom, @NotEmpty String description, List<Long> livreId,
            List<String> livreTitre) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        LivreId = livreId;
        LivreTitre = livreTitre;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Long> getLivreId() {
        return LivreId;
    }
    public void setLivreId(List<Long> livreId) {
        LivreId = livreId;
    }
    public List<String> getLivreTitre() {
        return LivreTitre;
    }
    public void setLivreTitre(List<String> livreTitre) {
        LivreTitre = livreTitre;
    }

}
