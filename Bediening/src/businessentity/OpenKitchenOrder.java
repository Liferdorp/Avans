/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessentity;


/**
 *
 * @author 23IVP4A2
 */
public class OpenKitchenOrder {

    public int status;
    private int dishId;
    private int tableNr;
    private int quantity;

    public OpenKitchenOrder(int status, int dishId, int quantity, int tableNr) {
        this.status = status;
        this.dishId = dishId;
        this.tableNr = tableNr;
        this.quantity = quantity;

    }

    @Override
    public String toString() {
        return ("Status: " + this.getStatus() + 
                " Dish ID: " + this.getdishId() + 
                " Table Number: " + this.getTableNr() + 
                " Quantity: " + this.getQuantity()) ;
    }
    
    public int getStatus() {
        return status;
    }

    public int getdishId() {
        return dishId;
    }

    public int getTableNr() {
        return tableNr;
    }

    public int getQuantity() {
        return quantity;
    }

}
