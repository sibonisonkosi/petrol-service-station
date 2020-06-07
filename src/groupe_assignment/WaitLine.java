/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package groupe_assignment;
//import java.util.Random;
import java.util.*;

/**
 *
 * @author Precious
 */
public class WaitLine <T>{
    private QueueInterface<String> VehicleQueue;
    private QueueInterface<String> pump1, pump2;
    private int numberOfArrivals, totalTimeWaited, totalArrivalTime, longestTimeWaited, p1_served, p2_served;
    
    public WaitLine(){
        VehicleQueue = new VehicleNodeClass<String>();
        pump1 = new VehicleNodeClass<String>();
        pump2 = new VehicleNodeClass<String>();
        numberOfArrivals = 0;
        p1_served = 0;
        p2_served = 0;
        totalTimeWaited = 0;
        longestTimeWaited =0;
        totalArrivalTime = 0;
    }
    public ArrayList<String> simulate(int duration, double arrivalProbability, double serviceChance){
        ArrayList<String> feedback = new ArrayList<String>();
        int p1_serviceTimeLeft = 0;
        int p2_serviceTimeLeft = 0;
        int ServiceTime =0;
        for(int i = 1; i < duration+1; i++){
            if(Math.random() <= arrivalProbability){
                numberOfArrivals++;
                //35% probability for a vehicle to be served 5 unit of time
                if(Math.random() <= serviceChance){
                    ServiceTime = 5;
                }
                else
                {
                    //65% probability for a vehicle to be served 3 unit of time
                    ServiceTime = 3;
                }
                
               if(VehicleQueue.isEmpty() && p1_serviceTimeLeft == 0){
                   //Index is the clock time
                    int index = i;
                    pump1.Enqueue(numberOfArrivals, ServiceTime, index);
                    p1_served++;
                    p1_serviceTimeLeft = ServiceTime;
                    int TimeWaited = index - index;
                    if(longestTimeWaited < TimeWaited){
                        longestTimeWaited = TimeWaited;
                    }
                    
                    totalArrivalTime = totalArrivalTime + index;
                    totalTimeWaited = totalTimeWaited + TimeWaited;
                    feedback.add("Vehicle Number " + numberOfArrivals + " Arrived at time unit " + i );
                    feedback.add("Vehicle Number " + numberOfArrivals + " Served at time unit " + i + " at pump 1");
                }
                else{
                    VehicleQueue.Enqueue(numberOfArrivals, ServiceTime, i);
                    feedback.add("Vehicle Number " + numberOfArrivals + " Arrived at time unit " + i );
                }
                
            }
            
            if(p1_serviceTimeLeft > 0){
                p1_serviceTimeLeft--;
                
            }else if(!VehicleQueue.isEmpty()){
                int index = i;
                VehicleNode nextVehicle = VehicleQueue.Dequeue();
                pump1.Dequeue();
                p1_serviceTimeLeft = (int)nextVehicle.getServiceTime() -1 ;
                int TimeWaited = index - (int)nextVehicle.getArrivalTime();
                if(longestTimeWaited < TimeWaited){
                        longestTimeWaited = TimeWaited;
                    }
                totalArrivalTime = totalArrivalTime + index;
                totalTimeWaited = totalTimeWaited + TimeWaited;
                p1_served++;
                feedback.add("Vehicle Number " + nextVehicle.getCarName() + " Served at time unit " + i + " at pump 1"); 
            }
            
            feedback.addAll(Service(i, p2_serviceTimeLeft));
        }
        return feedback;
    }
    public ArrayList<String> Arrivals(int i, int p1_STL,int SrvTime){
        ArrayList<String> results = new ArrayList<String>();
        
        if(VehicleQueue.isEmpty() && pump1.isEmpty()){
                    int index = i;
                    pump1.Enqueue(numberOfArrivals, SrvTime, i);
                    p1_served++;
                    p1_STL = SrvTime -1;
                    results.add(0,String.valueOf(p1_STL));
                    int TimeWaited = index - index;
                    if(longestTimeWaited < TimeWaited){
                        longestTimeWaited = TimeWaited;
                    }
                    
                    totalArrivalTime = totalArrivalTime + index;
                    totalTimeWaited = totalTimeWaited + TimeWaited;
                    results.add("Vehicle Number " + numberOfArrivals + " Arrived at time unit " + i );
                    results.add("Vehicle Number " + numberOfArrivals + " Served at time unit " + i + " at pump 1");
                }
                else{
                    VehicleQueue.Enqueue(numberOfArrivals, SrvTime, i);
                    results.add("Vehicle Number " + numberOfArrivals + " Arrived at time unit " + i );
                }
        
        return results;
    }
    public ArrayList<String> Service(int i, int p2_serviceTimeLeft){
        ArrayList<String> feedback = new ArrayList<String>();
        
        if(p2_serviceTimeLeft > 0){
                p2_serviceTimeLeft--;
                
            }else if(!VehicleQueue.isEmpty() && VehicleQueue.Size() > 2){
                int index = i;
                VehicleNode nextVehicle = VehicleQueue.Dequeue();
                pump2.Dequeue();
                p2_serviceTimeLeft = (int)nextVehicle.getServiceTime() - 1;
                int TimeWaited = index - (int)nextVehicle.getArrivalTime();
                if(longestTimeWaited < TimeWaited){
                        longestTimeWaited = TimeWaited;
                    }
                totalArrivalTime = totalArrivalTime + index;
                totalTimeWaited = totalTimeWaited + TimeWaited;
                p2_served++;
                feedback.add("Vehicle Number " + nextVehicle.getCarName() + " Served at time unit " + i + " at pump 2"); 
            }
        
        return feedback;
    }
    public ArrayList<String> displayResults(int duration) { 
        ArrayList<String> feedback = new ArrayList<String>();
        int numberServed = p1_served + p2_served;
        double averageTimeWaited = ((double)totalTimeWaited) / numberServed;
        int leftInLine = numberOfArrivals - numberServed;
        double AverageArrivalDiff = totalArrivalTime / numberOfArrivals;
        
        feedback.add("*** Simulation Summary ***"); 
        feedback.add("Simulation ran for " + duration +" units of time");
        feedback.add("Average arrival time difference between vehicles: " + AverageArrivalDiff); 
        feedback.add("Longest time that a vehicle waited: " + longestTimeWaited);
        feedback.add("Vehicles served at pump 1: " + p1_served);
        feedback.add("Vehicles served at pump 2: " + p2_served);
        feedback.add("Total number of vehicles served: " + numberServed); 
        feedback.add("Number of vehicles left in the queue: " + leftInLine);
        feedback.add("Average serving time: " + averageTimeWaited); 
        feedback.add("*** End of Report ***");
         
        return feedback;
       }
    
}
