/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import businessentity.OpenBarOrder;
import businessentity.OpenKitchenOrder;
import businessentity.OpenRestaurantOrder;
import presentation.LoginFrame;
import presentation.ScreenInfoFrame;
import businesslogic.SystemManager;
import datastorage.OpenBarOrdersDAO;
import datastorage.OpenKitchenOrdersDAO;
import datastorage.OpenRestaurantOrdersDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 23IVP4A2
 */
public class main {

    public static void main(String[] args) {

        LoginFrame ui = new LoginFrame();


        //print barorder
        OpenRestaurantOrdersDAO daoRestaurant = new OpenRestaurantOrdersDAO();

        ArrayList<OpenRestaurantOrder> restaurantOrders = daoRestaurant.getAllOpenRestaurantOrders(null);
        for (OpenRestaurantOrder restaurantOrder : restaurantOrders) {
            System.out.println(restaurantOrder.toString());
        }

        //Print kitchenorder
        OpenKitchenOrdersDAO daoKitchen = new OpenKitchenOrdersDAO();

        ArrayList<OpenKitchenOrder> kitchenOrders = daoKitchen.getAllOpenKitchenOrders(null);
        for (OpenKitchenOrder kitchenOrder : kitchenOrders) {
            System.out.println(kitchenOrder.toString());
        }
        
        

    }

}
