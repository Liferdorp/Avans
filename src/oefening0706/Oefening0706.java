/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oefening0706;
// Oefening 0706
public class Oefening0706 {
  public static void main( String[] args ) {
  	Voorraad voorraad = new Voorraad();
  	
  	voorraad.voegtoe( new Artikel( "notepad", 9 ) );
  	voorraad.voegtoe( new Artikel( "printer", 3 ) );
  	voorraad.voegtoe( new Artikel( "monitor", 8 ) );
  	
  	voorraad.print();
  }
}
