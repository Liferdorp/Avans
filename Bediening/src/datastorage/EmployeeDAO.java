///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package datastorage;
//
//import businessentity.Employee;
//import presentation.Test2;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Arrays;
//
//
//
///**
// *
// * @author 23IVP4A2
// */
//public class EmployeeDAO {
//
//    public EmployeeDAO() {
//
//    }
//
//    public ArrayList<Employee> getAllEmployee(Employee employee) {
//        ArrayList<Employee> getAllEmployee= new ArrayList<>();
//
//        if (true) {
//            // First open a database connnection
//            DatabaseConnection connection = new DatabaseConnection();
//            if (connection.openConnection()) {
//                // If a connection was successfully setup, execute the SELECT statement.
//                ResultSet resultset = connection.executeSQLSelectStatement(
//                        "SELECT id, userName, password, firstName, lastName FROM employee WHERE userName = " 
//                        + Test2.uname + " AND password = " + password + ";"
//                );
//
//                if (resultset != null) {
//                    try {
//                        while (resultset.next()) {
//                            // The value for the CopyID in the row is ignored
//                            // for this POC: no Copy objects are loaded. Having the
//                            // Loan objects without the Copy objects will do fine
//                            // to determine whether the owning Member can be removed.
//                            String userName = resultset.getString("userName");
//                            int employeeNr = resultset.getInt("ID");
//                            String password = resultset.getString("password");
//                            String firstName = resultset.getString("firstName");
//                            String lastName = resultset.getString("lastName");
//
//                            Employee newEmployee = new Employee(userName, employeeNr, password, firstName, lastName);
//                            getAllEmployee.add(newEmployee);
//                            // print
//                          //  OpenBarOrder[] array = new OpenBarOrder[] {newOpenBarOrder};
//                           //System.out.println(Arrays.toString(array));
//                        }
//                    } catch (SQLException e) {
//                        System.out.println(e);
//                        getAllEmployee.clear();
//                    }
//                }
//                // else an error occurred leave array list empty.
//
//                // We had a database connection opened. Since we're finished,
//                // we need to close it.
//                connection.closeConnection();
//
//            }
//
//        }
//        return getAllEmployee;
//    }
//
//}
