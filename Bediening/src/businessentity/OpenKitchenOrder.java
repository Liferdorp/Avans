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
    private int tableNr;

    public OpenKitchenOrder(int status, int tableNr) {
        this.status = status;
        this.tableNr = tableNr;
    }

    @Override
    public String toString() {
        return ("Status: " + this.getStatus() + 
                " Table Number: " + this.getTableNr());        
    }
    
    public int getStatus() {
        return status;
    }

    public int getTableNr() {
        return tableNr;
    }
    
}
