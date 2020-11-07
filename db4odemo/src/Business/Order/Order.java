/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Order;

import Business.Restaurant.MenuItem;
import Business.Role.CustomerRole;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author luoqi
 */
public class Order {
    private ArrayList<OrderItem> orderItemList;
    private int orderNumber;
    private UserAccount user;
    private static int count = 0;
    
    public Order(){
        count++;
        orderNumber = count; 
        orderItemList = new ArrayList<OrderItem>();
    }

    public UserAccount getUser() {
        return user;
    }

    public void setUser(UserAccount user) {
        this.user = user;
    }
    
    
    

    public ArrayList<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(ArrayList<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    
    public OrderItem addOrderItem(MenuItem mi, int q, double price,String name){
        OrderItem o = new OrderItem();
        o.setMenuItem(mi);
        o.setQuatity(q);
        o.setSalesPrice(price);
        o.setRestaurantName(name);
        orderItemList.add(o);
        return o;
    }
    
    public void removeOrder(OrderItem p){
        orderItemList.remove(p);
    }
    
}
