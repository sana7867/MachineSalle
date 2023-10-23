/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;

/**
 *
 * @author Tecra
 */
@Entity
@NamedQuery(name="findAllMachine", query="from Machine")
@NamedNativeQuery(name ="findAllMAchineNative",query="select * from machine", resultClass=Machine.class)
public class Machine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String marque;
    private String ref;
    private double prix;

    @ManyToOne
    @JoinColumn(name = "salle_id") // Spécifie la colonne qui fait référence à l'employé
    private Salle salle;

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Machine(String marque, String ref, double prix, Salle salle) {
        this.marque = marque;
        this.ref = ref;
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

    @Override
    public String toString() {
        return "Machine{" + "marque=" + marque + ", prix=" + prix + ", ref=" + ref + '}';
    }
    private static final long serialVersionUID = 123456789L;
    
}
