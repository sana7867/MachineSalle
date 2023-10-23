/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


public class Machine implements Serializable {
   
    private int id;
    private String marque;
     private String ref;
    private double prix;
    private Salle salle;
   
   
   private static final long serialVersionUID = 123456789L;

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }
   

    public Machine(String marque, String ref, double prix, Salle salle) {
        this.ref = ref;
        this.marque = marque;
        this.prix = prix;
        this.salle = salle;
    }

    public Machine() {
    }

    public Machine(String marque, String ref, double prix) {
        this.marque = marque;
        this.ref = ref;
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Machine{" + "marque=" + marque + ", ref=" + ref + ", prix=" + prix + ", salle=" + salle + '}';
    }

   
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

   
    
    
    
}
