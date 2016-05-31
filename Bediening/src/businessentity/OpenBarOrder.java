/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessentity;

/**
 *
 * @author Bas
 */
public class OpenBarOrder {
    private String status;
    private Date datum;
            
    public OpenBarOrder(String status){
        this.status = status;
        
    }
   
    public String getStatus(){
        return status;
    }
    
}

