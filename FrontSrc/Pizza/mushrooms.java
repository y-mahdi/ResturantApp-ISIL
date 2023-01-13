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
public class mushrooms extends PizzaDecourator{

    public mushrooms(Pizza.pizza pizza) {
        super(pizza);
    }
    public double getCost(){
        return super.getCost()+2.45;
    };
    public String getDescription(){
        return super.getDescription()+" ,Mushroom";
    };
    public String getSize(){
        return super.getSize();
    };
    
}
