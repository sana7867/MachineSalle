/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientrmi;

import dao.IDao;
import entities.Machine;
import entities.Salle;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tecra
 */
public class ClientRMI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
           
            IDao<Machine> dao1 = (IDao<Machine>) Naming.lookup("rmi://localhost:1099/dao1");
            dao1.create(new Machine("ref1","HP",  10000));
            dao1.create(new Machine("ref2","HP",  2000));
            dao1.create(new Machine("ref3","Mac",  30000));
            
            IDao<Salle> dao2 =  (IDao<Salle>) Naming.lookup("rmi://localhost:1099/dao2");
            dao2.create(new Salle("code1"));
            dao2.create(new Salle("code2"));
             for(Salle s : dao2.findAll()){
                   System.out.println("Salle  : "+s.getCode());
                   for(Machine m : s.getMachines())
                          System.out.println("\t"+m.getRef());
               }

        } catch (NotBoundException ex) {
            Logger.getLogger(ClientRMI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClientRMI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
