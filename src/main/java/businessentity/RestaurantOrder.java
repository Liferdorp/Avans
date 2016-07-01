/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.businessentity;

import java.sql.Date;
import java.sql.Time;



/**
 *
 * @author jessie
 */
public class RestaurantOrder {

    private int restaurantOrderId;
    private int tableNumber;
    private Date orderDate;
    private int statusID;
    private String statusName;
    private Time orderTime;

    public RestaurantOrder(int restaurantOrderId, int tableNumber, int statusID, String statusName, Date orderDate, Time orderTime) {
        this.restaurantOrderId = restaurantOrderId;
        this.tableNumber = tableNumber;
        this.statusID = statusID;
        this.statusName = statusName;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
    }
    
    public RestaurantOrder() {
        
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
    
    public String sql;
    
    
    public String setIdSql(int ID){
        
        return sql = "SELECT sum((barorder_drink.quantity * drink.price)) + sum((kitchenorder_dish.quantity * dish.price)) as sumprice, drink.price"
                    + " FROM barorder, barorder_drink, drink, kitchenorder, kitchenorder_dish, dish, restaurantorder"
                    + " WHERE barorder.restaurantOrderId = restaurantorder.id"
                    + " AND kitchenorder.restaurantOrderId = restaurantorder.id"
                    + " AND barorder_drink.barorderId = barorder.id"
                    + " AND barorder_drink.drinkId = drink.id"
                    + " AND kitchenorder_dish.kitchenOrderId = kitchenorder.id"
                    + " AND kitchenorder_dish.dishId = dish.id"
                    + " AND restaurantorder.id ='" + ID + "' ;";
    }

}