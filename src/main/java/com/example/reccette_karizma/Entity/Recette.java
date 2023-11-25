package com.example.reccette_karizma.Entity;

import jakarta.persistence.*;
@Entity
@Table(name = "Recette")
public class Recette {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nom;

        private String ingredients;

        private String etapesPreparation;

        private int dureePreparation;

        private String photo; // chemin vers la photo

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private utilisateur utilisateur;
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

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getEtapesPreparation() {
        return etapesPreparation;
    }

    public void setEtapesPreparation(String etapesPreparation) {
        this.etapesPreparation = etapesPreparation;
    }

    public int getDureePreparation() {
        return dureePreparation;
    }

    public void setDureePreparation(int dureePreparation) {
        this.dureePreparation = dureePreparation;
    }

    public String getPhoto() {
        return photo;
    }

    public com.example.reccette_karizma.Entity.utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(com.example.reccette_karizma.Entity.utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}


