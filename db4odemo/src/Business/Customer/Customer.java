/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.UserAccount.UserAccount;

/**
 *
 * @author harold
 */
public class Customer {
    private UserAccount user;
    
    public Customer(UserAccount user){
        this.user = user;
    }

    public UserAccount getUser() {
        return user;
    }
    
    
    @Override
    public String toString(){
        return user.getEmployee().getName();
    }
    
}
