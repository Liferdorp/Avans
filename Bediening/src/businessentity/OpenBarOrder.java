/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessentity;

import datastorage.OpenBarOrdersDAO;
import java.util.List;


/**
 *
 * @author 23IVP4A2
 */


public class OpenBarOrder {
    

    public int status;
    private int drinkId;
    private int tableNr;
    private int quantity;

    public OpenBarOrder(int status, int drinkId, int quantity, int tableNr) {
        this.status = status;
        this.drinkId = drinkId;
        this.tableNr = tableNr;
        this.quantity = quantity;
        
            OpenBarOrdersDAO dao = new OpenBarOrdersDAO();
            List<OpenBarOrder> test = dao.getAllOpenBarOrders(null);
            for (OpenBarOrder order : test) {
            System.out.println(order.toString());
        }

    }

    @Override
    public String toString() {
        return ("Status: " + this.getStatus() + 
                " Drink ID: " + this.getdrinkId() + 
                " Table Number: " + this.getTableNr() + 
                " Quantity: " + this.getQuantity()) ;
    }
    
    public int getStatus() {
        return status;
    }

    public int getdrinkId() {
        return drinkId;
    }

    public int getTableNr() {
        return tableNr;
    }

    public int getQuantity() {
        return quantity;
    }
    
}

