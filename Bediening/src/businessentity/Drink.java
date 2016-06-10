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
public class Drink {
    
    private String name;
    private double price;
    private int ID;

    public Drink(String name, double price, int ID) {
        this.name = name;
        this.price = price;
        this.ID = ID;
    }

    @Override
    public String toString() {
        return ("Naam: " + this.getName() + ", "
                + "Prijs: " + this.getPrice() + ", "
                + " ID: " + this.getID());
    }
    
    
    
    public String getName(){
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getID(){
        return ID;
    }
    
}
