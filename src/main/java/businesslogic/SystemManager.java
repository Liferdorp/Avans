
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.businesslogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import main.java.datastorage.DatabaseConnection;

/**
 *
 * @author 23IVP4A2
 */
public class SystemManager {

    public static String sqlLogIn = "SELECT id, userName, password, firstName, lastName, functionId FROM employee WHERE functionId = 2;";

    public static String countEmployee = "SELECT COUNT(id)FROM employee WHERE functionId = 2;";
    
    public DatabaseConnection dabaseConnection = new DatabaseConnection();
    public Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://145.48.6.147:3306/23ivp4a", "hha2_1user", "hha2pass");
    public Statement stmt = con.createStatement();
    
    

    public SystemManager() throws SQLException {
        

        

    }
}
