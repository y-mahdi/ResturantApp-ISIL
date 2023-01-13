/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveurresatu;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import Commande.CommandeService;
import Utilisateur.utilisateurService;

/**
 *
 * @author AZA
 */
public class ServeurResatu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException {
        try {
            LocateRegistry.createRegistry(1099);
            utilisateurService serviceuser=new utilisateurService();
            CommandeService serviceCommande=new CommandeService();
            Naming.rebind("rmi://localhost:1099/user",serviceuser);
            Naming.rebind("rmi://localhost:1099/commande",serviceCommande);
            System.out.println(serviceuser.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
    }
    
}
