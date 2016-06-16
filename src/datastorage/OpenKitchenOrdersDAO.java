/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastorage;

import businessentity.OpenKitchenOrder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author 23IVP4A2
 */
public class OpenKitchenOrdersDAO {

    public OpenKitchenOrdersDAO() {

    }

    public ArrayList<OpenKitchenOrder> getAllOpenKitchenOrders(OpenKitchenOrder openkitchenorders) {
        ArrayList<OpenKitchenOrder> getAllOpenKitchenOrders = new ArrayList<>();

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
                        + "`status`.`statusName`"
                        + "FROM `kitchenorder`, `restaurantorder`, `kitchenorder_dish`, `dish`, `status`"
                        + "WHERE (`kitchenorder`.`statusId` = 2 OR "
                        + "`kitchenorder`.`statusId` = 3 OR `kitchenorder`.`statusId` = 5) "
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

                            OpenKitchenOrder newOpenKitchenOrder = new OpenKitchenOrder(status, tableNr, dishName, quantity, kitchenOrderId, statusName);
                            getAllOpenKitchenOrders.add(newOpenKitchenOrder);
                            // print
                            //OpenKitchenOrder[] array = new OpenKitchenOrder[] {newOpenKitchenOrder};
                            //System.out.println(Arrays.toString(array));
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
