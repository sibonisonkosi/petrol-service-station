/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package groupe_assignment;

/**
 *
 * @author Precious
 */
public class VehicleNode<T> {
    VehicleNode next;
    T Car, serviceTime, arrivalTime;
    
    public VehicleNode(T Car, T serviceTime, T arrivalTime){
        this.Car = Car;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
        next = null;
    }
    public VehicleNode(VehicleNode next, T Car, T serviceTime, T arrivalTime){
        this.Car = Car;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
        this.next = next;
    }
    public void setNext( VehicleNode nxt){
        next = nxt;
    }
    public void setCarName(T value){
        Car = value;
    }
    public VehicleNode getNext(){
        return next;
    }
    public T getCarName(){
        return Car;
    }
    public T getServiceTime(){
        return serviceTime;
    }
    public T getArrivalTime(){
        return arrivalTime;
    }
    
}
