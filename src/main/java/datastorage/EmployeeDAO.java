/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.datastorage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import main.java.businessentity.Employee;

/**
 *
 * @author 23IVP4A2
 */
public class EmployeeDAO {

    public EmployeeDAO() {

    }

    public ArrayList<Employee> getAllEmployees(Employee employee) {
        ArrayList<Employee> getAllEmployees = new ArrayList<>();

        if (true) {
            // First open a database connnection
            DatabaseConnection connection = new DatabaseConnection();
            if (connection.openConnection()) {
                // If a connection was successfully setup, execute the SELECT statement.
                ResultSet resultset = connection.executeSQLSelectStatement(
                        "SELECT id, userName, password, firstName, lastName, functionId FROM employee WHERE functionId = 2;"
                );

                if (resultset != null) {
                    try {
                        while (resultset.next()) {
                            // The value for the CopyID in the row is ignored
                            // for this POC: no Copy objects are loaded. Having the
                            // Loan objects without the Copy objects will do fine
                            // to determine whether the owning Member can be removed.
                            int id = resultset.getInt("id");
                            String userName = resultset.getString("userName");
                            String password = resultset.getString("password");
                            String firstName = resultset.getString("firstName");
                            String lastName = resultset.getString("lastName");
                            int functionId = resultset.getInt("functionId");


                            Employee newEmployee = new Employee(id, userName, password, firstName, lastName, functionId);
                            getAllEmployees.add(newEmployee);
                        }
                    } catch (SQLException e) {
                        System.out.println(e);
                        getAllEmployees.clear();
                    }
                }
                // else an error occurred leave array list empty.

                // We had a database connection opened. Since we're finished,
                // we need to close it.
                connection.closeConnection();

            }

        }
        return getAllEmployees;
    }

}
