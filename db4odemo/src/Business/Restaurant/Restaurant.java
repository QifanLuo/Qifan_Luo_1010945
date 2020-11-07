/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;

import Business.Order.OrderItem;
import Business.UserAccount.UserAccount;

/**
 *
 * @author harold
 */
public class Restaurant {
    
    private String name;
    private OrderItem orderDirectory;
    private MenuList menulist;
    private UserAccount userAccount;
    
    public Restaurant(UserAccount userAccount, String Name){
        this.userAccount = userAccount;
        this.name = Name;
        menulist = new MenuList();
        
        
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OrderItem getOrderDirectory() {
        return orderDirectory;
    }

    public void setOrderDirectory(OrderItem orderDirectory) {
        this.orderDirectory = orderDirectory;
    }

    public MenuList getMenulist() {
        return menulist;
    }

    public void setMenulist(MenuList menulist) {
        this.menulist = menulist;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
    
    
    
    @Override
    public String toString(){
        return name;
    }
    
    
    
    
    
    
    
}
