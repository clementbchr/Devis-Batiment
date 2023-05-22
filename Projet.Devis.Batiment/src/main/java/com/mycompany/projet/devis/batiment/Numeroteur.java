   /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.projet.devis.batiment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


/**
 *
 * @author Amadou Coulibaly
 * @param <Coin>
 */
public class Numeroteur<Coin> {
    
    private List<Coin> objets;
    private HashMap<Coin,Integer> indexes;

    public Numeroteur() {
        this(new ArrayList<Coin>());
    }

    public Numeroteur(Collection<Coin> objets) {
        this.objets = new ArrayList<>();
        this.indexes = new HashMap<>(this.objets.size());
        for (int i = 0 ; i < this.objets.size() ; i ++) {
            this.indexes.put(this.objets.get(i), i);
        }
    }
    
    public int getOrAdd(Coin obj) {
        Integer res = this.indexes.get(obj);
        if (res == null) {
            res = this.objets.size();
            this.indexes.put(obj, res);
            this.objets.add(obj);
        }
        return res;
    }
     
     /**
     * retourne l'objet correspondant à un index.
     * @param index int
     * @return Object
     */
    public Coin getObject(int index) {
        Coin res = this.objets.get(index);
        if (res == null) {
            throw new IndexOutOfBoundsException();
        }
        return res;
    }

    /**
     * retourne tous les objets contenus dans le numéroteur.
     * @return Variable[] l'ensemble des variables du numéroteur
     */
    public Collection<Coin> getAllObjects() {
        return this.objets;
    }

    /**
     * retourne l'index correspondant à une variable.
     * @param var Variable var
     * @return int
     */
    public int getIndex(Coin var) {
        Integer res = this.indexes.get(var);
        if(res == null) {
            throw new IndexOutOfBoundsException();
        }
        return res;
    }

    public boolean add(Coin obj) {
        if (this.indexes.get(obj) == null) {
            this.indexes.put(obj, this.objets.size());
            this.objets.add(obj);
            return true;
        } else {
            return false;
        }
    }
    
    
}