/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet.devis.batiment;

/**
 *
 * @author Elève
 */
import java.util.List;

public class Piece {
    private List<Mur> listeMurs;
    private double hauteur;
    private Revetement revetementSol;
    private Revetement revetementPlafond;
    private Revetement revetementMurs;

    public Piece(List<Mur> listeMurs, double hauteur, Revetement revetementSol, Revetement revetementPlafond, Revetement revetementMurs) {
        this.listeMurs = listeMurs;
        this.hauteur = hauteur;
        this.revetementSol = revetementSol;
        this.revetementPlafond = revetementPlafond;
    }

    
    public List<Mur> getlisteMurs() {
        return listeMurs;
    }
    
    public Revetement getRevetementSol() {
        return revetementSol;
    }

    public void setRevetementSol(Revetement revetementSol) {
        this.revetementSol = revetementSol;
    }
    public Revetement getRevetementMurs() {
        return revetementMurs;
    }
    
    public void setRevetementMurs(Revetement revetementMur) {
        this.revetementMurs = revetementMur;
    }

    public Revetement getRevetementPlafond() {
        return revetementPlafond;
    }

    public void setRevetementPlafond(Revetement revetementPlafond) {
        this.revetementPlafond = revetementPlafond;
    }
    
    public double surfaceSol() {
        double surface = 0;
        for (Mur mur : listeMurs) {
            surface += mur.surface();
        }
        return surface;
    }

    public double surfacePlafond() {
        return surfaceSol();
    }

    public double surfaceMur() {
        double surface = 0;
        for (Mur mur : listeMurs) {
            surface += mur.getlongueur() * hauteur;
        }
        return surface;
    }

    public double surfaceTotale() {
        return surfaceMur() + surfaceSol() + surfacePlafond();
    }

    public double montantRevetementSol() {
        double surface = surfaceSol();
        double prix = revetementSol.getPrixUnitaire() * surface;
        return prix;
    }

    public double montantRevetementPlafond() {
        double surface = surfacePlafond();
        double prix = revetementPlafond.getPrixUnitaire() * surface;
        return prix;
    }

    public double montantRevetementMur(Revetement revetement) {
        double surface = surfaceMur();
        double prix = revetement.getPrixUnitaire() * surface;
        return prix;
    }

    public double calculerDevisPiece() {
        double devisTotal = 0;
        devisTotal += montantRevetementSol();
        devisTotal += montantRevetementPlafond();
        for (Mur mur : listeMurs) {
            for (Revetement revetement : mur.getListeRevetement()) {
                devisTotal += mur.montantRevetement(revetement);
            }
        }
        return devisTotal;
    }
    
    public void ajouterMur(Mur mur) {
        listeMurs.add(mur);
    }

    public void afficher() {
        System.out.println("Pièce composée de " + listeMurs.size() + " murs.");
        System.out.println("Surface totale : " + surfaceTotale() + " m²");
        System.out.println("Surface des murs : " + surfaceMur() + " m²");
        System.out.println("Surface du sol : " + surfaceSol() + " m²");
        System.out.println("Surface du plafond : " + surfacePlafond() + " m²");
        System.out.println("Montant du revêtement de sol : " + montantRevetementSol() + " €");
        System.out.println("Montant du revêtement de plafond : " + montantRevetementPlafond() + " €");
        System.out.println("Montant total du devis de la pièce : " + calculerDevisPiece() + " €");
    }
}