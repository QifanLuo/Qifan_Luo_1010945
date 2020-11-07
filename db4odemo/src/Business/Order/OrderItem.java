/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Order;

import Business.Restaurant.MenuItem;

/**
 *
 * @author luoqi
 */
public class OrderItem {
    private int quatity;
    private double salesPrice;
    private MenuItem menuItem;
    private String restaurantName;
    private boolean isProcessbyRestaurant;
    
    
    public OrderItem(){
        isProcessbyRestaurant = false;
    }

    public boolean isIsProcessbyRestaurant() {
        return isProcessbyRestaurant;
    }

    public void setIsProcessbyRestaurant(boolean isProcessbyRestaurant) {
        this.isProcessbyRestaurant = isProcessbyRestaurant;
    }


    
    
    
    
    

    public int getQuatity() {
        return quatity;
    }

    public void setQuatity(int quatity) {
        this.quatity = quatity;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }
    
    
    
    
        @Override
    public String toString(){
        return menuItem.getName();
    }
    
    
}
