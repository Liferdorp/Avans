/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessentity;

/**
 *
 * @author 23IVP4A2
 */
public class Employee {
    
    private String userName;
    private int employeeNr;
    private String password;
    private String lastName;
    private String firstName;

    public Employee(String userName, int employeeNr, String password, String firstName, String lastName) {
        this.userName = userName;
        this.employeeNr = employeeNr;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        
    }
    
        @Override
    public String toString() {
        return ("Voornaam: " + this.getFirstName()
                +"Achternaam: " + this.getLastName()
                +"Gebruikersnaam: " + this.getUserName()
                +"Werknemer nummer: " + this.getEmployeeNr());
    }
    

    
    public int getEmployeeNr(){
        return employeeNr;
    }
    
    public String getPassword(){
        return password;
    }
    
     public String getUserName(){
        return userName;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
}
