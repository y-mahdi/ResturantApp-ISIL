/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Commande.CommandeService;
import Commande.commande;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author AZA
 */
public class test {
    public static void main(String[] args) throws SQLException, RemoteException {
        Statement St;
        Connection db;
        ResultSet Rs;
        db=DBConnection.DBConnection.getInstance();
        St=db.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        String username="waiter1";
        String password="hello";
        String type="w";
        boolean info=false;
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
        System.out.println(info);
    }
}
