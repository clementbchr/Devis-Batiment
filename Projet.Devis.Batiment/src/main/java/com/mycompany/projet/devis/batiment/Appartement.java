package com.mycompany.projet.devis.batiment;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aedel01
 */
import java.util.ArrayList;
import java.util.List;

public class Appartement {
    private int idAppartement;
    private int niveau;
    private List<Piece> listePieces;

    public Appartement(int idAppartement, int niveau) {
        this.idAppartement = idAppartement;
        this.niveau = niveau;
        this.listePieces = new ArrayList<>();
    }

    public int getIdAppartement() {
        return idAppartement;
    }

    public int getNiveau() {
        return niveau;
    }

    public void ajouterPiece(Piece piece) {
        listePieces.add(piece);
    }

    public double calculerSurfaceAppartement() {
        double surfaceTotale = 0;
        for (Piece piece : listePieces) {
            surfaceTotale += piece.surfaceTotale();
        }
        return surfaceTotale;
    }

    public double calculerDevisAppartement() {
        double devisTotal = 0;
        for (Piece piece : listePieces) {
            devisTotal += piece.calculerDevisPiece();
        }
        return devisTotal;
    }

    public void afficher() {
        System.out.println("Appartement #" + idAppartement);
        System.out.println("Niveau : " + niveau);
        System.out.println("Nombre de pièces : " + listePieces.size());
        System.out.println("Surface totale de l'appartement : " + calculerSurfaceAppartement() + " m²");
        System.out.println("Devis total de l'appartement : " + calculerDevisAppartement() + " €");
        System.out.println("Détail des pièces :");
        for (Piece piece : listePieces) {
            piece.afficher();
            System.out.println("--------------------");
        }
    }
}