/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
 

import businessentity.OpenKitchenOrder;
import presentation.ScreenInfoFrame;
import businesslogic.SystemManager;
import datastorage.OpenBarOrdersDAO;
import datastorage.OpenKitchenOrdersDAO;
import java.util.Arrays;

/**
 *
 * @author 23IVP4A2
 */



 public class main {

    
   
    public static void main(String[] args) {

        ScreenInfoFrame ui = new ScreenInfoFrame(new SystemManager());
        ui.setVisible(true);
        
        OpenBarOrdersDAO Dao = new OpenBarOrdersDAO ();
        

        
                OpenKitchenOrder testOrder = new OpenKitchenOrder(1, 2, 3, 4);
                OpenKitchenOrder[] array = new OpenKitchenOrder[] {testOrder};
                System.out.println(Arrays.toString(array));

    }
        
}
