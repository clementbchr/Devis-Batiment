/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet.devis.batiment;

import java.util.ArrayList;
import java.util.List;

public class Niveau {
    private int idNiveau;
    private List<Appartement> listeAppartements;
    private double longueurCouloir;
    private double largeurCouloir;
    private Revetement revetementCouloir;

    public Niveau(int idNiveau, double longueurCouloir, double largeurCouloir, Revetement revetementCouloir) {
        this.idNiveau = idNiveau;
        this.longueurCouloir = longueurCouloir;
        this.largeurCouloir = largeurCouloir;
        this.revetementCouloir = revetementCouloir;
        this.listeAppartements = new ArrayList<>();
    }

    public void ajouterAppartement(Appartement appartement) {
        listeAppartements.add(appartement);
    }

    public double calculerSurfaceNiveau() {
        double surface = 0;
        for (Appartement appartement : listeAppartements) {
            surface += appartement.calculerSurfaceAppartement();
        }
        surface += calculerSurfaceCouloir();
        return surface;
    }

    public double calculerDevisNiveau() {
        double devisTotal = 0;
        for (Appartement appartement : listeAppartements) {
            devisTotal += appartement.calculerDevisAppartement();
        }
        devisTotal += calculerDevisCouloir();
        return devisTotal;
    }

    public double calculerSurfaceCouloir() {
        return longueurCouloir * largeurCouloir;
    }

    public double calculerDevisCouloir() {
        double surface = calculerSurfaceCouloir();
        double prix = revetementCouloir.getPrixUnitaire() * surface;
        return prix;
    }

    public void afficher() {
        System.out.println("Niveau " + idNiveau);
        System.out.println("Surface totale du niveau : " + calculerSurfaceNiveau() + " m²");
        System.out.println("Montant total du devis du niveau : " + calculerDevisNiveau() + " €");
    }
}