/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.businessentity;

/**
 *
 * @author jessi
 */
public class Employee {
    
    private final int id;
    private final String userName;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final int functionId;

    public Employee(int id, String userName, String password, String firstName, String lastName, int functionId) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.functionId = functionId;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getFunctionId() {
        return functionId;
    }
    
    
    
}
