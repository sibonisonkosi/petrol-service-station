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
public interface QueueInterface<T> {
    public void Enqueue(int vehicle, int serviceTime, int arrivalTime);
    public VehicleNode Dequeue();
    public void Clear();
    public T peek();
    public boolean isEmpty();
    public int Size();
}
