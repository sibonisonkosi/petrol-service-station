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
public class VehicleNodeClass<T> implements QueueInterface<T> {
   private VehicleNode head;
    private int size;
    
    public VehicleNodeClass(){
        head = null;
        size = 0;
    }
    
    public void Addfront(int vehicle, int serviceTime, int arrivalTime) {
        head = new VehicleNode(head, vehicle, serviceTime, arrivalTime);
        size++;
    }

    @Override
    public void Enqueue(int vehicle,int serviceTime, int arrivalTime) {
        VehicleNode current = head;
        int cnt = 1;
        while(current != null && cnt < size){
            current = current.getNext();
            cnt++;
        }
        if(current != null){
            VehicleNode newNode = new VehicleNode(vehicle, serviceTime, arrivalTime);
            current.setNext(newNode);
            size++;
        }
        else{
            Addfront(vehicle, serviceTime, arrivalTime);
        }
    }

    @Override
    public VehicleNode Dequeue() {
       VehicleNode old = null;
       if(!isEmpty()){
           old =  head;
           head = head.getNext();
           size--;
       }
       return old;
    }

    @Override
    public void Clear() {
        head = null;
        size = 0;
    }
    
    @Override
    public int Size() {
       return size;
    }

    @Override
    public T peek() {
        T front = null;
        if(!isEmpty()){
            front = (T) head.Car;
        }
        return front;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    } 
}
