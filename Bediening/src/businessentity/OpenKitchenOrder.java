/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessentity;

/**
 *
 * @author jessi
 */
public class OpenKitchenOrder {
    
    private String status;
    
    public OpenKitchenOrder(String status){
        this.status = status;
        
    }
   
    public String getStatus(){
        return status;
    }
    
}
