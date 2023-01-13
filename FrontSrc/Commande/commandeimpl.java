/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commande;

import java.io.Serializable;

/**
 *
 * @author AZA
 */
public class commandeimpl implements Serializable,CommandeDAO{
    String ClientName,Description;
    double cost;
    public commandeimpl(String clientName,String Description,double cost){
        this.ClientName=clientName;
        this.Description=Description;
        this.cost=cost;
    }
    @Override
    public String getDescription() {
        return Description;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public String getClientName() {
        return ClientName;
    }
    
}
