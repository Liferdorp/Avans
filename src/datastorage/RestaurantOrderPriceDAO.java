/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastorage;

import businessentity.OpenKitchenOrder;
import businessentity.RestaurantOrderPrice;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 23IVP4A2
 */
public class RestaurantOrderPriceDAO {

    public RestaurantOrderPriceDAO() {

    }

    public ArrayList<RestaurantOrderPrice> getAllRestaurantOrderPrice(RestaurantOrderPrice restaurantorderprice) {
        ArrayList<RestaurantOrderPrice> getAllRestaurantOrderPrice = new ArrayList<>();

        if (true) {
            // First open a database connnection
            DatabaseConnection connection = new DatabaseConnection();
            if (connection.openConnection()) {
                // If a connection was successfully setup, execute the SELECT statement.
                ResultSet resultset = connection.executeSQLSelectStatement(
                        "SELECT sum((`barorder_drink`.`quantity` * `drink.price`)) + sum((`kitchenorder_dish`.`quantity` * `dish.price`))"
                        + "FROM `barorder`, `barorder_drink`, `drink`, `kitchenorder`, `kitchenorder_dish`, `dish`, `restaurantorder`"
                        + "WHERE `barorder`.`restaurantOrderId` = `restaurantorder`.`id`"
                        + "AND `kitchenorder`.`restaurantOrderId` = `restaurantorder`.`id`"
                        + "AND `barorder_drink`.`barorderId` = `barorder`.`id`"
                        + "AND `barorder_drink`.`drinkId` = `drink`.`id`"
                        + "AND `kitchenorder_dish`.`kitchenOrderId` = `kitchenorder`.`id`"
                        + "AND `kitchenorder_dish`.`dishId` = `dish`.`id`"
                        + "AND `restaurantorder`.`id` = '" + 1 + "' ;"
                );

                if (resultset != null) {
                    try {
                        while (resultset.next()) {
                            // The value for the CopyID in the row is ignored
                            // for this POC: no Copy objects are loaded. Having the
                            // Loan objects without the Copy objects will do fine
                            // to determine whether the owning Member can be removed.
                            Long restaurantOrderPrice = resultset.getLong("statusId");

                            RestaurantOrderPrice newRestaurantOrderPrice = new RestaurantOrderPrice(restaurantOrderPrice);
                            getAllRestaurantOrderPrice.add(newRestaurantOrderPrice);
                            // print
                            //OpenKitchenOrder[] array = new OpenKitchenOrder[] {newOpenKitchenOrder};
                            //System.out.println(Arrays.toString(array));
                        }
                    } catch (SQLException e) {
                        System.out.println(e);
                        getAllRestaurantOrderPrice.clear();
                    }
                }
                // else an error occurred leave array list empty.

                // We had a database connection opened. Since we're finished,
                // we need to close it.
                connection.closeConnection();

            }

        }
        return getAllRestaurantOrderPrice;
    }

}
