/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luoqi
 */
public class MenuList {
    private List<MenuItem> menulist;
    
    public MenuList(){
        menulist = new ArrayList<MenuItem>();
    }

    public List<MenuItem> getMenulist() {
        return menulist;
    }

    public void setMenulist(List<MenuItem> menulist) {
        this.menulist = menulist;
    }
    
    
        
    
}
