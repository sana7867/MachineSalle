package server;

import dao.IDao;
import entities.Machine;
import entities.Salle;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.MachineService;
import service.SalleService;

public class Server {

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);

            IDao<Machine> dao1 = new MachineService();
            Naming.bind("rmi://localhost:1099/dao1", dao1);

            IDao<Salle> dao2 = new SalleService();
            Naming.bind("rmi://localhost:1099/dao2", dao2);

            System.out.println("Serveur RMI en attente des clients...");
        } catch (RemoteException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, "Erreur lors de la création du registre RMI", ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, "URL RMI mal formée", ex);
        } catch (AlreadyBoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, "Liaison d'objet déjà effectuée", ex);
        }
    }
}
