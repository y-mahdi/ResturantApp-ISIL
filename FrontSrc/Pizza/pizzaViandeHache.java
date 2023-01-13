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
public class pizzaViandeHache implements pizza {
    private String Description="Pizza viande Hache";
    private String Size;
    private double cost=20.22;
    
    public pizzaViandeHache(){
        
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
        return Size;
    }
    public void setSize(String Size){
        this.Size=Size;
    }
    
    
}
