package com.example.express.Entity;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
public class Catalogue {
    
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String nom;

    @Column(nullable=false)
    private String description ;

@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name="Catalogue_livre",
            joinColumns={@JoinColumn(name="Catalogue_id", referencedColumnName="ID")},
            inverseJoinColumns={@JoinColumn(name="livre_id", referencedColumnName="ID")})
    private List<Livre> livre = new ArrayList<>();
  


    
    public Catalogue(Long id, String nom, String description, List<Livre> livre) {
    this.id = id;
    this.nom = nom;
    this.description = description;
    this.livre = livre;
}



    public Catalogue() {
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



    public List<Livre> getLivre() {
        return livre;
    }



    public void setLivre(List<Livre> livre) {
        this.livre = livre;
    }

   



}


    
