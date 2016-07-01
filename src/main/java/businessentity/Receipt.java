/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.businessentity;


/**
 *
 * @author jessi
 */
public class Receipt {
    
    public String sql;
    public String sql2;
    
    public String getEmployeeId(String firstName){
        return sql2 = "SELECT id FROM employee WHERE firstName = '" + firstName + "';";
    }
    
    public String SetStatusReceipt(int employeeId, String checkoutDate, int id, double totalPrice){
        
        return sql = "INSERT INTO `receipt` (`employeeId`, `price`, `restaurantOrderId`, `checkoutDate`) VALUES (" + employeeId + " , " + totalPrice + ", " + id + ", " + checkoutDate + ");";
    };
    

    
}
