package Business;

import Business.DeliveryMan.DeliveryMan;
import Business.DeliveryMan.DeliveryManDirectory;
import Business.Employee.Employee;
import Business.Employee.EmployeeDirectory;
import Business.Order.MasterOrderCatalog;
import Business.Restaurant.MenuItem;
import Business.Restaurant.Restaurant;
import Business.Restaurant.RestaurantDirectory;
import Business.Role.AdminRole;
import Business.Role.CustomerRole;
import Business.Role.DeliverManRole;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author rrheg
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        
        RestaurantDirectory resturantlist  = new RestaurantDirectory();
        system.setRestaurantDirectory(resturantlist);
        MasterOrderCatalog masterOrderCatalog = new MasterOrderCatalog();
        system.setMasterOrderCatalog(masterOrderCatalog);
        DeliveryManDirectory deliveryManlist = new DeliveryManDirectory();
        system.setDeliveryManDirectory(deliveryManlist);
        
        
             
        Employee employee = system.getEmployeeDirectory().createEmployee("RRH");        
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", employee, new SystemAdminRole());
        
        
        Employee cus = system.getEmployeeDirectory().createEmployee("customer");
        UserAccount customer = system.getUserAccountDirectory().createUserAccount("customer", "customer", cus, new CustomerRole());
        CustomerRole cus1 = (CustomerRole) customer.getRole();

 
        
        Employee adi1 = system.getEmployeeDirectory().createEmployee("admin_K");
        UserAccount admin_K = system.getUserAccountDirectory().createUserAccount("admin_K", "admin_K", adi1, new AdminRole());
        Restaurant KFC = new Restaurant(admin_K, "KFC");
        system.getRestaurantDirectory().getRestaurantList().add(KFC);
        MenuItem humberg = new MenuItem();
        humberg.setAvailNum(100);
        humberg.setName("humberg");
        humberg.setPrice(15.0);
        KFC.getMenulist().getMenulist().add(humberg);
        AdminRole Arole1 = (AdminRole)admin_K.getRole();
        Arole1.setRestaurant(KFC);
                
        Employee adi2 = system.getEmployeeDirectory().createEmployee("admin_M");
        UserAccount admin_M = system.getUserAccountDirectory().createUserAccount("admin_M", "admin_M", adi2, new AdminRole());
        Restaurant McDonald = new Restaurant(admin_M, "McDonald");
        system.getRestaurantDirectory().getRestaurantList().add(McDonald);
        MenuItem frenchFries = new MenuItem();
        frenchFries.setAvailNum(100);
        frenchFries.setName("French fries");
        frenchFries.setPrice(15.0);
        McDonald.getMenulist().getMenulist().add(frenchFries);
        AdminRole Arole2 = (AdminRole)admin_M.getRole();
        Arole2.setRestaurant(McDonald);
        
        Employee del1 = system.getEmployeeDirectory().createEmployee("deliverMan1");
        UserAccount deliverMan1 = system.getUserAccountDirectory().createUserAccount("deliverMan1", "deliverMan1", del1, new DeliverManRole());
        DeliveryMan dm1 = new DeliveryMan(deliverMan1);
        system.getDeliveryManDirectory().getDeliveryManList().add(dm1);
        
        Employee del2 = system.getEmployeeDirectory().createEmployee("deliverMan2");
        UserAccount deliverMan2 = system.getUserAccountDirectory().createUserAccount("deliverMan2", "deliverMan2", del2, new DeliverManRole());
        DeliveryMan dm2 = new DeliveryMan(deliverMan2);
        system.getDeliveryManDirectory().getDeliveryManList().add(dm2);
       
        
        return system;
    }
    
}
