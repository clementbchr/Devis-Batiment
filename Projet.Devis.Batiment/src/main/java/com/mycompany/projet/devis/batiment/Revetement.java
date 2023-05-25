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
import java.util.ArrayList;

public class Revetement {
    private int idRevetement;
    private String designation;
    private boolean pourMur;
    private boolean pourSol;
    private boolean pourPlafond;
    private double prixUnitaire;
    private static List<Revetement> listRevetements = new ArrayList<>();

    public Revetement(int idRevetement, String designation, boolean pourMur, boolean pourSol, boolean pourPlafond, double prixUnitaire) {
        this.idRevetement = idRevetement;
        this.designation = designation;
        this.pourMur = pourMur;
        this.pourSol = pourSol;
        this.pourPlafond = pourPlafond;
        this.prixUnitaire = prixUnitaire;
    }

    public int getIdRevetement() {
        return idRevetement;
    }

    public String getDesignation() {
        return designation;
    }

    public boolean isPourMur() {
        return pourMur;
    }

    public boolean isPourSol() {
        return pourSol;
    }

    public boolean isPourPlafond() {
        return pourPlafond;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public static List<Revetement> getListRevetements() {
        return listRevetements;
    }

    public static void chargerRevetements() {
        listRevetements.clear();

        Object[][] data = {
            {1, "Peinture", true, false, true, 10.95},
            {2, "Carrelage", true, true, false, 49.75},
            {3, "Lambris", true, true, true, 50.60},
            {4, "Marbre", true, true, false, 97.85},
            {5, "Crépi", true, false, false, 67.80},
            {6, "Papier peint", true, false, false, 32.90},
            {7, "Plaquettes de parement", true, false, false, 15.20},
            {8, "Peinture", true, false, true, 77.30},
            {9, "Peinture", true, false, true, 29.90},
            {10, "Carrelage", true, true, false, 89.45},
            {11, "Lambris", true, true, false, 42.50},
            {12, "Liège", true, false, false, 25.40},
            {13, "Parquet", false, true, false, 46.36},
            {14, "Vinyle Lino", false, true, false, 23.55},
            {15, "Moquette", false, true, false, 48.10},
            {16, "Stratifié", false, true, false, 31.99},
            {17, "Gazon", false, true, false, 17.95},
            {18, "Liège", false, true, false, 33.90}
        };

        for (Object[] row : data) {
            int idRevetement = (int) row[0];
            String designation = (String) row[1];
            boolean pourMur = (boolean) row[2];
            boolean pourSol = (boolean) row[3];
            boolean pourPlafond = (boolean) row[4];
            double prixUnitaire = (double) row[5];

            Revetement revetement = new Revetement(idRevetement, designation, pourMur, pourSol, pourPlafond, prixUnitaire);
            listRevetements.add(revetement);
        }
    }
}
    

