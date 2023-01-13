/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilisateur;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author AZA
 */
public interface Utlisateur extends Remote {
        public boolean login(String username,String password,String type) throws RemoteException;
}
