/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author luoqi
 */
public class CarDirectory {
    
    private ArrayList<Car> carList;

    public CarDirectory() {
        this.carList = new ArrayList<Car>();
    }

    public ArrayList<Car> getAccountList() {
        return carList;
    }

    public void setAccountList(ArrayList<Car> accountList) {
        this.carList = accountList;
    }

    public Car addCar(){
        Car car = new Car();
        carList.add(car);
        return car;
    }
    
    public void deleteAccount(Car car){
        carList.remove(car);
    }
    
    
    public Car searchSerialNumber(String serialNumber){
        for(Car car:carList){
            if(car.getSerialNumber().equals(serialNumber)){
                return car;
            }
        }
        
        return null;
    }
    
    
    public ArrayList<Car> getAvailableCarList(ArrayList<Car> carList) {
        ArrayList<Car> availableCarList = new ArrayList<Car>();
        
        for(Car car : carList){
            if(car.isStatus()){
                availableCarList.add(car);
            }
        }
              
        return availableCarList;       
    }
    
    
}
