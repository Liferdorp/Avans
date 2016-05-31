/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastorage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import businessentity.Drink;

/**
 *
 * @author jessi
 */
public class DrinksDAO {
    
    public DrinksDAO(){
    
}
    
        public List<Drinks> getAllDrinks (Drink drinks) {
        List<Drinks> getAllDrinks = new ArrayList<>();

        if (drinks != null) {
            // First open a database connnection
            DatabaseConnection connection = new DatabaseConnection();
            if (connection.openConnection()) {
                // If a connection was successfully setup, execute the SELECT statement.
                int membershipNumber = member.getMembershipNumber();
                ResultSet resultset = connection.executeSQLSelectStatement(
                        "SELECT * FROM loan WHERE MembershipNr = " + membershipNumber + ";");

                if (resultset != null) {
                    try {
                        while (resultset.next()) {
                            // The value for the CopyID in the row is ignored
                            // for this POC: no Copy objects are loaded. Having the
                            // Loan objects without the Copy objects will do fine
                            // to determine whether the owning Member can be removed.
                            Date returnDate = resultset.getDate("ReturnDate");

                            Drinks newLoan = new Drinks(returnDate, drinks, null);
                            loans.add(newLoan);
                        }
                    } catch (SQLException e) {
                        System.out.println(e);
                        loans.clear();
                    }
                }
                // else an error occurred leave array list empty.

                // We had a database connection opened. Since we're finished,
                // we need to close it.
                connection.closeConnection();
            }
        }

        
    

