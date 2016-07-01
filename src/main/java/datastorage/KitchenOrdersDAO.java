/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.datastorage;

import main.java.businessentity.KitchenOrder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 23IVP4A2
 */
public class KitchenOrdersDAO {

    public KitchenOrdersDAO() {

    }

    public ArrayList<KitchenOrder> getAllOpenKitchenOrders(KitchenOrder openkitchenorders) {
        ArrayList<KitchenOrder> getAllOpenKitchenOrders = new ArrayList<>();

        if (true) {
            // First open a database connnection
            DatabaseConnection connection = new DatabaseConnection();
            if (connection.openConnection()) {
                // If a connection was successfully setup, execute the SELECT statement.
                ResultSet resultset = connection.executeSQLSelectStatement(
                        "SELECT `kitchenorder`.`id`,"
                        + "`kitchenorder`.`orderDate`, "
                        + "`kitchenorder`.`restaurantOrderId`, "
                        + "`kitchenorder`.`statusId`, "
                        + "`restaurantorder`.`id`, "
                        + "`restaurantorder`.`tableNumber`,"
                        + "`kitchenorder_dish`.`kitchenOrderId`,"
                        + "`kitchenorder_dish`.`dishId`,"
                        + "`kitchenorder_dish`.`quantity`,"
                        + "`dish`.`dishName`,"
                        + "`dish`.`price`,"
                        + "`status`.`statusName`"
                        + "FROM `kitchenorder`, `restaurantorder`, `kitchenorder_dish`, `dish`, `status`"
                        + "WHERE (`kitchenorder`.`statusId` = 2 OR "
                        + "`kitchenorder`.`statusId` = 3 OR `kitchenorder`.`statusId` = 4) "
                        + "AND `kitchenorder`.`restaurantOrderId`=`restaurantorder`.`id` "
                        + "AND `kitchenorder`.`id` = `kitchenorder_dish`.`kitchenOrderId`"
                        + "AND `kitchenorder_dish`.`dishId` = `dish`.`id`"
                        + "AND `status`.`id` = `kitchenorder`.`statusId`"
                        + "ORDER BY `kitchenorder`.`id` ASC;"
                        
                );

                if (resultset != null) {
                    try {
                        while (resultset.next()) {
                            // The value for the CopyID in the row is ignored
                            // for this POC: no Copy objects are loaded. Having the
                            // Loan objects without the Copy objects will do fine
                            // to determine whether the owning Member can be removed.
                            int status = resultset.getInt("statusId");
                            int tableNr = resultset.getInt("tableNumber");
                            String dishName = resultset.getString("dishName");
                            int quantity = resultset.getInt("quantity");
                            int kitchenOrderId = resultset.getInt("id");
                            String statusName = resultset.getString("statusName");
                            int restaurantOrderId = resultset.getInt("restaurantOrderId");
                            double kitchenOrderPrice = resultset.getDouble("price");

                            KitchenOrder newOpenKitchenOrder = new KitchenOrder(status, tableNr, dishName, quantity, kitchenOrderId, statusName, restaurantOrderId, kitchenOrderPrice);
                            getAllOpenKitchenOrders.add(newOpenKitchenOrder);
                        }
                    } catch (SQLException e) {
                        System.out.println(e);
                        getAllOpenKitchenOrders.clear();
                    }
                }
                // else an error occurred leave array list empty.

                // We had a database connection opened. Since we're finished,
                // we need to close it.
                connection.closeConnection();

            }

        }
        return getAllOpenKitchenOrders;
    }

}
