package com.example.express.Entity;


import java.util.ArrayList;

import java.util.List;
import jakarta.persistence.*;

@Entity
public class Livre {
    
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String titre;

    @Column(nullable=false)
    private String auteur ;

    @Column(nullable=false)
    private String date_pub;


     @Column(nullable=false)
    private Long num_ESRN;

    @Column(nullable=false)
    private int Exemplaire ;

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name="livre_cat",
            joinColumns={@JoinColumn(name="livre_id", referencedColumnName="ID")},
            inverseJoinColumns={@JoinColumn(name="categorie_id", referencedColumnName="ID")})
    private List<Categorie> categories = new ArrayList<>();
  







    public Livre(Long id, String titre, String auteur, String date_pub, Long num_ESRN, int exemplaire,
            List<Categorie> categories) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.date_pub = date_pub;
        this.num_ESRN = num_ESRN;
        Exemplaire = exemplaire;
        this.categories = categories;
    }




    public Livre() {
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




    public List<Categorie> getCategories() {
        return categories;
    }




    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }




    public String getDate_pub() {
        return date_pub;
    }




    public void setDate_pub(String date_pub) {
        this.date_pub = date_pub;
    }





}
