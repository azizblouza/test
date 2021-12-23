package com.vermeg.bookstore_springboot.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        private int id_categorie;

    public Categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    @Column(name = "label")

        private String label ;
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "Categorie")
    private List<Livre> livres;

    public List<Livre> getLivres() {
        return livres;
    }

    public void setLivres(List<Livre> livres) {
        this.livres = livres;
    }

    public Categorie(int id_categorie, String label, List<Livre> livres) {
        this.id_categorie = id_categorie;
        this.label = label;
        this.livres = livres;
    }

    public Categorie(int id_categorie, String label) {
        this.id_categorie = id_categorie;
        this.label = label;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Categorie() {
    }
}
