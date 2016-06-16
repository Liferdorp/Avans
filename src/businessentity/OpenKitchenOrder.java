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

    private int status;
    private int tableNr;
    private String dishName;
    private int kitchenOrderId;
    private int quantity;
    private String statusName;

    public OpenKitchenOrder(int status, int tableNr, String dishName, int quantity, int kitchenOrderId, String statusName) {
        this.status = status;
        this.tableNr = tableNr;
        this.dishName = dishName;
        this.quantity = quantity;
        this.kitchenOrderId = kitchenOrderId;
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return ("Status: " + this.getStatus()  + ", "
                + " Table Number: " + this.getTableNr());        
    }
    
    public int getStatus() {
        return status;
    }

    public int getTableNr() {
        return tableNr;
    }
    
    public String getDishName(){
        return dishName;
    }
    
    public int getKitchenOrderId(){
        return kitchenOrderId;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public String getStatusName(){
        return statusName;
    }
}
