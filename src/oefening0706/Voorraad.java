/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oefening0706;
import java.util.*;

public class Voorraad {
  private ArrayList<Artikel> lijst;
  
  public Voorraad() {
  	lijst = new ArrayList<Artikel>();
  }
  
  public void voegtoe( Artikel artikel ) {
  	lijst.add( artikel );
  }
  
  public void print() {
  	System.out.println( "Voorraad" );
  	for( Artikel artikel : lijst ) {
      System.out.println( artikel );
  	}
  }
}
