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
public class olives extends PizzaDecourator{

    public olives(pizza pizza) {
        super(pizza);
    }
    public double getCost(){
        return super.getCost()+1.5;
    };
    public String getDescription(){
        return super.getDescription()+",Olives";
    };
    public String getSize(){
        return super.getSize();
    };
    
}
