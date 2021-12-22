package com.vermeg.bookstore_springboot.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "Commande")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_Commande;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_client", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Client client;
    @Column(name = "date_Commande")
    private LocalDate date_Commande ;
    @Column(name = "quantite")
    private int quantite;
    @Column(name = "prix_Total")
    private int prix_Total;

    public int getId_Commande() {
        return id_Commande;
    }

    public void setId_Commande(int id_Commande) {
        this.id_Commande = id_Commande;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getDate_Commande() {
        return date_Commande;
    }

    public void setDate_Commande(LocalDate date_Commande) {
        this.date_Commande = date_Commande;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getPrix_Total() {
        return prix_Total;
    }

    public void setPrix_Total(int prix_Total) {
        this.prix_Total = prix_Total;
    }

    public Commande() {
    }

    public Commande(int id_Commande, Client client, LocalDate date_Commande, int quantite, int prix_Total) {
        this.id_Commande = id_Commande;
        this.client = client;
        this.date_Commande = date_Commande;
        this.quantite = quantite;
        this.prix_Total = prix_Total;
    }
}
