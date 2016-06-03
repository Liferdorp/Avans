
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import businessentity.OpenBarOrder;
import businessentity.OpenKitchenOrder;
import datastorage.OpenKitchenOrdersDAO;
import datastorage.OpenBarOrdersDAO;
import java.util.ArrayList;

/**
 *
 * @author 23IVP4A2
 */
public class SystemManager {

    public String openOrder;
    public String employee;
    public String acceptedKitchenOrder;
    public String acceptedBarOrder;
    public String drink;

    public String getOpenOrder() {
        return openOrder;
    }

    public String getEmployee() {
        return employee;
    }

    public String getAcceptedKitchenOrder() {
        return acceptedKitchenOrder;
    }

    public String getAcceptedBarOrder() {
        return acceptedBarOrder;
    }

    public String getDrink() {
        return drink;
    }

    OpenKitchenOrdersDAO openKitchenOrderDAO = new OpenKitchenOrdersDAO();
    ArrayList<OpenKitchenOrder> openkitchenorder;

}
