/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commande;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author AZA
 */
public interface commande extends Remote{
    public void insertCommande(String Detail,double prix,String NomClient) throws RemoteException;
    public void setLivrer(int idCommande) throws RemoteException;
    public void setPres(int idCommande) throws RemoteException;
    public String[][]getCommandeOfWaiter() throws RemoteException;
    public String[][] getCommandeOfChef() throws RemoteException;
    public int commandesWaiterNumber() throws RemoteException;
    public int commandeChefNumber() throws RemoteException;
}
