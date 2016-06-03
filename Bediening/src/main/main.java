/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
 

import businessentity.OpenBarOrder;
import presentation.ScreenInfoFrame;
import businesslogic.SystemManager;
import datastorage.OpenBarOrdersDAO;
import java.util.ArrayList;

/**
 *
 * @author 23IVP4A2
 */



 public class main {

    
   
    public static void main(String[] args) {

        ScreenInfoFrame ui = new ScreenInfoFrame(new SystemManager());
        ui.setVisible(true);
        
        OpenBarOrdersDAO dao = new OpenBarOrdersDAO ();
        

        
               
                ArrayList<OpenBarOrder> test=dao.getAllOpenBarOrders(null);
                for(OpenBarOrder order : test){
                    System.out.println(order.toString());
                }
                

    }
        
}
