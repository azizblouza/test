package com.vermeg.bookstore_springboot.entities;
import javax.persistence.*;

@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        private int id_categorie;
    @Column(name = "label")
        private String label ;

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
