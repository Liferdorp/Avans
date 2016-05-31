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
import java.util.List;

/**
 *
 * @author Bas
 */
public class OpenKitchenOrdersDAO {

    public OpenKitchenOrdersDAO() {

    }

    public List<OpenKitchenOrder> getAllOpenKitchenOrders(OpenKitchenOrder openkitchenorders) {
        List<OpenKitchenOrder> getAllOpenKitchenOrders = new ArrayList<>();

        if (openkitchenorders != null) {
            // First open a database connnection
            DatabaseConnection connection = new DatabaseConnection();
            if (connection.openConnection()) {
                // If a connection was successfully setup, execute the SELECT statement.
                ResultSet resultset = connection.executeSQLSelectStatement(
                        "SELECT * FROM kitchenorder WHERE statusId = 5 OR 6;"
                );

                if (resultset != null) {
                    try {
                        while (resultset.next()) {
                            // The value for the CopyID in the row is ignored
                            // for this POC: no Copy objects are loaded. Having the
                            // Loan objects without the Copy objects will do fine
                            // to determine whether the owning Member can be removed.

                            OpenKitchenOrder newOpenKitchenOrder = new OpenKitchenOrder(4);
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
