/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessentity;

/**
 *
 * @author jessi
 */
public class RestaurantOrderPrice {
    
    static private long restaurantOrderPrice;

    public RestaurantOrderPrice(long restaurantOrderPrice) {
        this.restaurantOrderPrice = restaurantOrderPrice;
    }

    static public long getRestaurantOrderPrice() {
        return restaurantOrderPrice;
    }
    
    
    
}
