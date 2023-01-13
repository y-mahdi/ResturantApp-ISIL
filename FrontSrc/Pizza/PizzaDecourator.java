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
public class PizzaDecourator implements pizza {
    private pizza pizza;
    public PizzaDecourator(pizza pizza){
        this.pizza=pizza;
    }
    @Override
    public double getCost() {
        return pizza.getCost();
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public String getSize() {
        return pizza.getSize();
    }

    @Override
    public void setSize(String Size) {
        pizza.setSize(Size);
    }
    
   
}
