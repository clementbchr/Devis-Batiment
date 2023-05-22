/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet.devis.batiment;

/**
 *
 * @author sdukic01
 */

import java.util.List;
import java.util.ArrayList;

public class Mur {
    private static int compteur = 0;
    private int idMur;
    private Coin CoinDebut;
    private Coin CoinFin;
    private int nbrePorte;
    private int nbreFenetre;
    private List<Revetement> listeRevetement;
    private double longueur;

    private Revetement revetementSol;
    private Revetement revetementPlafond;

    public Revetement getRevetementSol() {
        return revetementSol;
    }

    public void setRevetementSol(Revetement revetementSol) {
        this.revetementSol = revetementSol;
    }

    public Revetement getRevetementPlafond() {
        return revetementPlafond;
    }

    public void setRevetementPlafond(Revetement revetementPlafond) {
        this.revetementPlafond = revetementPlafond;
    }
     
    public Mur(int idMur, Coin debut, Coin fin) {
        this.idMur = ++compteur;
        this.CoinDebut = debut;
        this.CoinFin = fin;
        this.listeRevetement = new ArrayList<>();
        this.revetementSol = null;
        this.revetementPlafond = null;
    }
    

    public int getIdMur() {
        return idMur;
    }

    public Coin getCoinDebut() {
        return CoinDebut;
    }

    public Coin getCoinFin() {
        return CoinFin;
    }

    public int getNbrePorte() {
        return nbrePorte;
    }

    public int getNbreFenetre() {
        return nbreFenetre;
    }

    public List<Revetement> getListeRevetement() {
        return listeRevetement;
    }
    
    public List<Revetement> setlisteRevetement() {
        return listeRevetement;
    }

    public double surface() {
        double largeur = Math.abs(this.CoinDebut.getCx() - this.CoinFin.getCx());
        double hauteur = 2.30;

        // On calcule la surface totale
        double surface = largeur * hauteur;

        // On enlève la surface des portes et fenêtres
        if (this.nbrePorte > 0) {
            surface -= this.nbrePorte * 1.89; // On considère une porte standard de 1.89m2
        }

        if (this.nbreFenetre > 0) {
            surface -= this.nbreFenetre * 1.44; // On considère une fenêtre standard de 1.44m2
        }

        return surface;
    }

    public double montantRevetement(Revetement revetement) {
        double surface = surface();
        double prix = revetement.getPrixUnitaire() * surface;
        return prix;
    }

    public double longueur() {
        double longueur = Math.sqrt(Math.pow((CoinDebut.getCx() - CoinFin.getCx()), 2) + Math.pow((CoinDebut.getCy() - CoinFin.getCy()), 2));
        return longueur;
    }
    public double getlongueur(){
        return longueur;
    }

    public void afficher() {
        System.out.println("Mur " + this.idMur + ":");
        System.out.println("  - Coin de début: " + this.CoinDebut);
        System.out.println("  - Coin de fin: " + this.CoinFin);
        System.out.println("  - Nombre de portes: " + this.nbrePorte);
        System.out.println("  - Nombre de fenêtres: " + this.nbreFenetre);
        System.out.println("  - Surface: " + surface() + " m²");
    }

    @Override
    public String toString() {
    return "Mur{idMur=" + idMur +
            ", coinDebut=" + CoinDebut +
            ", coinFin=" + CoinFin +
            ", nbrePortes=" + nbrePorte +
            ", nbreFenetres=" + nbreFenetre +
            ", listerevetement=" + listeRevetement +
            '}';
}
    
    
    
}





