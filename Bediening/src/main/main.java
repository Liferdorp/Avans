/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import businessentity.OpenBarOrder;
import businessentity.OpenKitchenOrder;
import presentation.MyLogin;
import presentation.ScreenInfoFrame;
import businesslogic.SystemManager;
import datastorage.OpenBarOrdersDAO;
import datastorage.OpenKitchenOrdersDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 23IVP4A2
 */
public class main {

    public static void main(String[] args) {

        MyLogin ui = new MyLogin();


        //print barorder
        OpenBarOrdersDAO daoBar = new OpenBarOrdersDAO();

        ArrayList<OpenBarOrder> barOrders = daoBar.getAllOpenBarOrders(null);
        for (OpenBarOrder barOrder : barOrders) {
            System.out.println(barOrder.toString());
        }

        //Print kitchenorder
        OpenKitchenOrdersDAO daoKitchen = new OpenKitchenOrdersDAO();

        ArrayList<OpenKitchenOrder> kitchenOrders = daoKitchen.getAllOpenKitchenOrders(null);
        for (OpenKitchenOrder kitchenOrder : kitchenOrders) {
            System.out.println(kitchenOrder.toString());
        }
        
        

    }

}
