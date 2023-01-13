/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainClient;
import client.FinalizeOrder;
import client.OrderMenu;



/**
 *
 * @author AZA
 */
public class MainClient{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*try {
            Utlisateur test=(Utlisateur)Naming.lookup("rmi://localhost:1099/user");
            boolean data=test.login("waiter", "0000", "w");
            System.out.println(data);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        */
        /*new OrderMenu().setVisible(true);*/
        new OrderMenu().setVisible(true);
    }
    
}
