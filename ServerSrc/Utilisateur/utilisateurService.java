/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilisateur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;

/**
 *
 * @author AZA
 */
public class utilisateurService extends UnicastRemoteObject implements Utlisateur {
    Statement St;
    Connection db;
    ResultSet Rs;
    public utilisateurService() throws RemoteException, SQLException{
        super();
        this.db=DBConnection.DBConnection.getInstance();
        this.St=this.db.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    }
    @Override
    public boolean login(String username, String password, String type) {
        boolean info=false;
        try {
            Rs=St.executeQuery("select count(*) as nm from userrestau where type='"+type+"' and username='"+username+"' ");
            while(Rs.next()){
                if(Rs.getInt("nm")==0){
                    info=false;
                    System.out.println("is not found");
                }
                else{
                    System.out.println("Is Finded");
                    Rs=St.executeQuery("select count(*) as nm from userrestau where type='"+type+"' and username='"+username+"' and password='"+password+"' ");
                    while(Rs.next()){
                        if(Rs.getInt("nm")==1){
                            info=true;
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return info;
    }
    
}
