/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oefening0706;
public class Artikel {
  private String omschrijving;
  private int aantal;

  public Artikel( String omschrijving, int aantal ) {
    this.omschrijving = omschrijving;
    this.aantal = aantal;
  }
  public String toString() {
    return String.format( "%-40s  aantal: %4d", omschrijving, aantal );
  }
}
