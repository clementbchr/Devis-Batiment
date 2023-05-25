/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet.devis.batiment;

/**
 *
 * @author sdukic01
 */
public class Coin {

    /**
     *
     * @return
     */
    @Override

    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("Coin{");

        sb.append("idCoin=").append(idCoin);

        sb.append(", cx=").append(cx);

        sb.append(", cy=").append(cy);

        sb.append('}');

        return sb.toString();

    }

    // Attributs

    int idCoin;

    double cx;

    double cy;
    
    private static int dernierId = 0;
    

    // Constructeur

    /**
     *
     * @param id
     * @param x
     * @param y
     */


   public Coin(int id, double x, double y)

    {

      this.idCoin=dernierId++;

      this.cx=x;

      this.cy=y;

    }

    // Méthodes get
    public int getIdCoin() {
        return idCoin;
    }

    public double getCx() {
        return cx;
    }

    public double getCy() {
        return cy;
    }

    /**
     *
     */
    public void afficher()

    {

        System.out.println(" Coin : id ="+this.idCoin+" abscisse = "+this.cx+ " Ordonnée ="+this.cy);

    }

            

}
    
    
    
    
    


