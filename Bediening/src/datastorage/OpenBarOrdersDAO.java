/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastorage;

import businessentity.OpenBarOrder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;



/**
 *
 * @author 23IVP4A2
 */
public class OpenBarOrdersDAO {

    public OpenBarOrdersDAO() {

    }

    public ArrayList<OpenBarOrder> getAllOpenBarOrders(OpenBarOrder openbarorders) {
        ArrayList<OpenBarOrder> getAllOpenBarOrders = new ArrayList<>();

        if (openbarorders != null) {
            // First open a database connnection
            DatabaseConnection connection = new DatabaseConnection();
            if (connection.openConnection()) {
                // If a connection was successfully setup, execute the SELECT statement.
                ResultSet resultset = connection.executeSQLSelectStatement(
                        "SELECT `barorder`.`id`,"
                        + "`barorder`.`orderDate`, "
                        + "`barorder`.`restaurantOrderId`, "
                        + "`barorder`.`statusId`, "
                        + "`restaurantorder`.`id`, "
                        + "`restaurantorder`.`tableNr`"
                        + "`barorder_drink`.`barOrderId`"
                        + "`barorder_drink`.`drinkId`"
                        + "`barorder_drink`.`quantity`"
                        + "FROM barorder, restaurantorder, barorder_drink "
                        + "WHERE statusId = 4 OR "
                        + "statusId = 6 "
                        + "AND `barorder`.`restaurantOrderId`=`restaurantorder`.`id` "
                        + "AND `barorder`.`id` = `barorder_drink`.`barOrderId`;"
                );

                if (resultset != null) {
                    try {
                        while (resultset.next()) {
                            // The value for the CopyID in the row is ignored
                            // for this POC: no Copy objects are loaded. Having the
                            // Loan objects without the Copy objects will do fine
                            // to determine whether the owning Member can be removed.
                            int status = resultset.getInt("statusId");
                            int drinkId = resultset.getInt("drinkId");
                            int quantity = resultset.getInt("quantity");
                            int tableNr = resultset.getInt("tableNr");

                            OpenBarOrder newOpenBarOrder = new OpenBarOrder(status, drinkId, quantity, tableNr);
                            getAllOpenBarOrders.add(newOpenBarOrder);
                            // print
                            OpenBarOrder[] array = new OpenBarOrder[] {newOpenBarOrder};
                            System.out.println(Arrays.toString(array));
                        }
                    } catch (SQLException e) {
                        System.out.println(e);
                        getAllOpenBarOrders.clear();
                    }
                }
                // else an error occurred leave array list empty.

                // We had a database connection opened. Since we're finished,
                // we need to close it.
                connection.closeConnection();

            }

        }
        return getAllOpenBarOrders;
    }

}
