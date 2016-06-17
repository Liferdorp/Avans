
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import datastorage.DatabaseConnection;
import presentation.LoginFrame;
import presentation.PayedFrame;

/**
 *
 * @author 23IVP4A2
 */
public class SystemManager {
    

    public static String sqlLogIn = "SELECT id, userName, password, firstName, lastName, functionId FROM employee WHERE functionId = 2;";
    

    LoginFrame ui = new LoginFrame();
    DatabaseConnection dabaseConnection = new DatabaseConnection();

}
