/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessentity;

import java.sql.Date;
import java.sql.Time;



/**
 *
 * @author jessi
 */
public class OpenRestaurantOrder {

    private int restaurantOrderId;
    private int tableNumber;
    private Date orderDate;
    private int statusID;
    private String statusName;
    private Time orderTime;

    public OpenRestaurantOrder(int restaurantOrderId, int tableNumber, int statusID, String statusName, Date orderDate, Time orderTime) {
        this.restaurantOrderId = restaurantOrderId;
        this.tableNumber = tableNumber;
        this.statusID = statusID;
        this.statusName = statusName;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
    }

    @Override
    public String toString() {
        return "OpenRestaurantOrder{" + "restaurantOrderId=" + restaurantOrderId + ", tableNumber=" + tableNumber + ", statusID=" + statusID + ", statusName=" + statusName + '}';
    }

    public int getId() {
        return restaurantOrderId;
    }

    public int getTableNumber() {
        return tableNumber;
    }
    
    public Date getOrderDate(){
        return orderDate;
    }
    
    public Time getOrderTime(){
        return orderTime;
    }

    public int getStatusID() {
        return statusID;
    }

    public String getStatusName() {
        return statusName;
    }

}
