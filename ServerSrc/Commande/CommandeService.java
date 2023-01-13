/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commande;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AZA
 */
public class CommandeService extends UnicastRemoteObject implements commande {
    Statement St;
    Connection db;
    ResultSet Rs;
    public CommandeService() throws RemoteException, SQLException{
        super();
        this.db=DBConnection.DBConnection.getInstance();
        this.St=this.db.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    }
    @Override
    public void insertCommande(String Detail, double prix, String NomClient) {
        try {
            St.executeUpdate("insert into commande(idcommande,DetailCommande,prix,pres,livrer,clientNom) values(CommandeIdSequence.nextval,'"+Detail+"',"+prix+",'f','f','"+NomClient+"')");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void setLivrer(int idCommande) {
        try {
            St.executeQuery("update commande set livrer='t' where idcommande="+idCommande);
        } catch (Exception e) {
        }
    }

    @Override
    public void setPres(int idCommande) {
        try {
            St.executeQuery("update commande set livrer='t' where idcommande="+idCommande);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public String[][] getCommandeOfWaiter() throws RemoteException {
        int n=0;
        try {
            n = new CommandeService().commandeChefNumber();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        String[][] data;
        data = new String[n][];
        int i=0;
        try {
            Rs=St.executeQuery("select * from commande where pres='t' and livrer='f' ");
            while(Rs.next()){
                /*data[Rs.getInt("idcommande")-1][0]=String.valueOf(Rs.getInt("idcommande"));
                data[Rs.getInt("idcommande")-1][1]=Rs.getString("DetailCommande");
                data[Rs.getInt("idcommande")-1][2]=String.valueOf(Rs.getInt("prix"));
                data[Rs.getInt("idcommande")-1][3]=Rs.getString("clientNom");
                data[Rs.getInt("idcommande")-1][4]=Rs.getDate("DateCommande").toString();
                /*System.out.println(Rs.getInt("idcommande"));*/
                data[i]=new String[]{String.valueOf(Rs.getInt("idcommande")),
                    Rs.getString("DetailCommande"),String.valueOf(Rs.getInt("prix")),
                    Rs.getString("clientNom"),Rs.getDate("DateCommande").toString()};
                i++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return data;
    }

    @Override
    public String[][] getCommandeOfChef() throws RemoteException {
        int n=0;
        try {
            n = new CommandeService().commandeChefNumber();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        String[][] data;
        data = new String[n][];
        int i=0;
        try {
            Rs=St.executeQuery("select * from commande where pres='f' and livrer='f' ");
            while(Rs.next()){
                /*data[Rs.getInt("idcommande")-1][0]=String.valueOf(Rs.getInt("idcommande"));
                data[Rs.getInt("idcommande")-1][1]=Rs.getString("DetailCommande");
                data[Rs.getInt("idcommande")-1][2]=String.valueOf(Rs.getInt("prix"));
                data[Rs.getInt("idcommande")-1][3]=Rs.getString("clientNom");
                data[Rs.getInt("idcommande")-1][4]=Rs.getDate("DateCommande").toString();
                /*System.out.println(Rs.getInt("idcommande"));*/
                data[i]=new String[]{String.valueOf(Rs.getInt("idcommande")),
                    Rs.getString("DetailCommande"),String.valueOf(Rs.getInt("prix")),
                    Rs.getString("clientNom"),Rs.getDate("DateCommande").toString()};
                i++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return data;
    }

   

    @Override
    public int commandesWaiterNumber() {
        int n=0;
        try {
            Rs=St.executeQuery("select count(*) as n from commande where pres='t' and livrer='f'");
            while(Rs.next()){
                n=Rs.getInt("n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return n;
    }

    @Override
    public int commandeChefNumber() {
        int n=0;
        try {
            Rs=St.executeQuery("select count(*) as n from commande where pres='f'");
            while(Rs.next()){
                n=Rs.getInt("n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return n;
    }
    
}
