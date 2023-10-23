/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;


public class Salle implements Serializable {
   
    private int id;
    private String code;

    private List<Machine> machines;
    
 private static final long serialVersionUID = 1L;



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
    
    
}
