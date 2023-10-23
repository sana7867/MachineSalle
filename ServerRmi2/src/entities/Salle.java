/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Tecra
 */
@Entity
@NamedQuery(name="findAllSalle", query="from Salle")

public class Salle implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String code;

    @OneToMany(mappedBy = "salle",fetch = FetchType.EAGER) // Référence le nom du champ dans la classe Projet
    private List<Machine> machines;
    
  


    public Salle(String code, List<Machine> machines) {
        this.code = code;
        this.machines = machines;
    }

    public List<Machine> getMachines() {
        return machines;
    }

    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }

    public Salle(String code) {
        this.code = code;
    }
    
    public Salle() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Salle{" + "code=" + code + '}';
    }
    private static final long serialVersionUID = 1L;

    
}
