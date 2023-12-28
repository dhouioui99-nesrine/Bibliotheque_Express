package com.example.express.Entity;


    import jakarta.persistence.*;
    import java.util.List;
    
    
    @Entity
    public class Categorie
    {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    
        @Column(nullable=false, unique=true)
        private String name;
    
        @ManyToMany(mappedBy="categories")
        private List<Livre> livres;

        public Categorie() {
        }

        public Categorie(Long id, String name, List<Livre> livres) {
            this.id = id;
            this.name = name;
            this.livres = livres;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Livre> getLivres() {
            return livres;
        }

        public void setLivres(List<Livre> livres) {
            this.livres = livres;
        }
      
}
