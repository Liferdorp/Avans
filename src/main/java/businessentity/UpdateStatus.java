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
public class UpdateStatus {

    public String sqlDeliveredBar;
    public String sqlDeliveredKitchen;
    public String sqlAcceptedBar;
    public String sqlAcceptedKitchen;
    public String sqlPayed;
    public String sqlFirstName;
    
    public UpdateStatus(){
        
    }
    
    public String getEmployeeId(String firstName){
        return sqlFirstName = "SELECT id FROM employee WHERE firstName = '" + firstName + "';";
    }

    public String sqlUpdateDeliveredBar(int employeeId, int ID) {
        return sqlDeliveredBar = "UPDATE barorder SET statusId=4, employeeId='" + employeeId + "' where id='" + ID + "' ;";
    }

    public String sqlUpdateDeliveredKitchen(int employeeId, int ID) {
        return sqlDeliveredKitchen = "UPDATE kitchenorder SET statusId=4, employeeId='" + employeeId + "' where id='" + ID + "' ;";
    }

    public String sqlUpdateAcceptedBar(int employeeId, int ID) {
        return sqlAcceptedBar = "UPDATE barorder SET statusId=2, employeeId='" + employeeId + "' where id='" + ID + "' ;";
    }

    public String sqlUpdateAcceptedKitchen(int employeeId, int ID) {
        return sqlAcceptedKitchen = "UPDATE kitchenorder SET statusId=2, employeeId='" + employeeId + "' where id='" + ID + "' ;";
    }

    public String sqlPayed(int employeeId, int ID) {
        return sqlPayed = "UPDATE `restaurantorder`,`receipt` SET `restaurantorder`.`statusId`=6, `receipt`.`employeeId`= " + employeeId + " where `restaurantorder`.`id`= " + ID + " ;";
    }

}
