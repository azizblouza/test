package com.vermeg.bookstore_springboot.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "Titre")
    private String Titre;
    @Column(name = "Auteur")
    private String Auteur;
    @Column(name = "Prix")
    private double prix;
    @Column(name = "release")
    private LocalDate release;
    @Column(name = "img")
    private String img;
    @Column(name = "Stock")
    private int Stock;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }

    public String getAuteur() {
        return Auteur;
    }

    public void setAuteur(String auteur) {
        Auteur = auteur;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public LocalDate getRelease() {
        return release;
    }

    public void setRelease(LocalDate release) {
        this.release = release;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public Livre() {
    }

    public Livre(int id, String titre, String auteur, double prix, LocalDate release, String img, int stock) {
        this.id = id;
        Titre = titre;
        Auteur = auteur;
        this.prix = prix;
        this.release = release;
        this.img = img;
        Stock = stock;
    }
}
