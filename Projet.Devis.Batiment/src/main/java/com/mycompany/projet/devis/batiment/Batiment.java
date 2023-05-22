
package com.mycompany.projet.devis.batiment;

import java.util.ArrayList;
import java.util.List;

public class Batiment {
    private List<Niveau> listeNiveaux;
    private double hauteurNiveau;
    private double largeurEscalier;
    private double longueurEscalier;
    private Revetement revetementEscalier;

    public Batiment(double hauteurNiveau, double largeurEscalier, double longueurEscalier) {
        this.hauteurNiveau = hauteurNiveau;
        this.largeurEscalier = largeurEscalier;
        this.longueurEscalier = longueurEscalier;
        this.revetementEscalier = new Revetement(1, "Papier peint", true, false, false, 32.90);
        this.listeNiveaux = new ArrayList<>();
    }

    public void ajouterNiveau(Niveau niveau) {
        listeNiveaux.add(niveau);
    }

    public double calculerSurfaceEscalier() {
    double surface = 2 * (largeurEscalier * longueurEscalier + hauteurNiveau * largeurEscalier + hauteurNiveau * longueurEscalier);
    double surfacePortes = 1.89 * listeNiveaux.size();
    return surface - surfacePortes;
}

    public double calculerHauteurBatiment() {
        return hauteurNiveau * listeNiveaux.size();
    }

    public double calculerDevisBatiment() {
        double devisTotal = 0;
        for (Niveau niveau : listeNiveaux) {
            devisTotal += niveau.calculerDevisNiveau();
        }
        devisTotal += calculerDevisEscalier();
        return devisTotal;
    }

    public double calculerDevisEscalier() {
        double surface = calculerSurfaceEscalier();
        double prix = revetementEscalier.getPrixUnitaire() * surface;
        return prix;
    }

    public void afficher() {
        System.out.println("Bâtiment");
        System.out.println("Hauteur du bâtiment : " + calculerHauteurBatiment() + " m");
        System.out.println("Montant total du devis du bâtiment : " + calculerDevisBatiment() + " €");
    }
}