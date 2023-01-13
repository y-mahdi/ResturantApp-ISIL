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
public class frommage extends PizzaDecourator{

    public frommage(Pizza.pizza pizza) {
        super(pizza);
    }
    public double getCost(){
        return super.getCost()+2.45;
    };
    public String getDescription(){
        return super.getDescription()+" ,Frommage";
    };
    public String getSize(){
        return super.getSize();
    };
    
}
