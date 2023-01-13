/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pizza;

/**
 *
 * @author AZA
 */
public class pizzaPoulet implements pizza {
    private double cost=15.5;
    private String Description="Pizza Poulet";
    private String size;
    public pizzaPoulet(){
        
    }
    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public String getDescription() {
        return Description;
    }

    @Override
    public String getSize() {
        return size;
    }
    @Override
    public void setSize(String Size){
        this.size=Size;
    }
    
}
