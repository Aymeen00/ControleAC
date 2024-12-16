package org.sid.bouanan_aymen_controle_2.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Entity
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private Double prix;

    @ManyToOne
    @JoinColumn(name = "auteur_id")
    private Auteur auteur;

    public Livre(String titre, Double prix, Optional<Auteur> auteurById) {
    }

    public Livre(Long id, String titre, Double prix, Auteur auteur) {
        this.id = id;
        this.titre = titre;
        this.prix = prix;
        this.auteur = auteur;
    }

    public Livre() {
    }

    // Getters and setters
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

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }
}
