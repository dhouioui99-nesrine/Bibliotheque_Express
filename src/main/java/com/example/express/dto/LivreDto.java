package com.example.express.dto;


import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;

public class LivreDto {
     private Long id;
    @NotEmpty
    private String titre;
    @NotEmpty
    private String auteur;
    @NotEmpty
    @DateTimeFormat
    private String date_pub;
    @NotEmpty
    private Long num_ESRN;
    @NotEmpty
    private int Exemplaire;

    private List<Long> categorieIds;
    private List<String> categorieNames;



   
   

    public LivreDto(Long id, @NotEmpty String titre, @NotEmpty String auteur, @NotEmpty String date_pub,
            @NotEmpty Long num_ESRN, @NotEmpty int exemplaire, List<Long> categorieIds, List<String> categorieNames) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.date_pub = date_pub;
        this.num_ESRN = num_ESRN;
        Exemplaire = exemplaire;
        this.categorieIds = categorieIds;
        this.categorieNames = categorieNames;
    }

    public LivreDto() {
    }
   
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public String getAuteur() {
        return auteur;
    }
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
  
    public Long getNum_ESRN() {
        return num_ESRN;
    }
    public void setNum_ESRN(Long num_ESRN) {
        this.num_ESRN = num_ESRN;
    }
    public int getExemplaire() {
        return Exemplaire;
    }
    public void setExemplaire(int exemplaire) {
        Exemplaire = exemplaire;
    }
   
    public List<String> getCategorieNames() {
        return categorieNames;
    }
    public void setCategorieNames(List<String> categorieNames) {
        this.categorieNames = categorieNames;
    }

    public List<Long> getCategorieIds() {
        return categorieIds;
    }

    public void setCategorieIds(List<Long> categorieIds) {
        this.categorieIds = categorieIds;
    }

    public String getDate_pub() {
        return date_pub;
    }

    public void setDate_pub(String date_pub) {
        this.date_pub = date_pub;
    }


    
}
