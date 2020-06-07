"# petrol-service-station" 

Given the queue interface on page 276 (3rd edition) in your prescribed text book, you are required to code this interface, as well as an implementation of queueInterface.  You can choose between any of the following implementation:- Vector, Array, Linked nodes, Doubly Linked Nodes.   
 
Now that you have a queue, use this to perform the following simulation. Use the values given (% chance) as default values, but allow the user to make changes to these values should they desire. These changes would be made before the simulation is run. 
 
You are required to develop a simulation for a petrol service station that operates two petrol pumps.  
 
Pump 1 is always open. Pump 2 opens if there are more than two vehicles in the queue, and closes when the queue is empty. Vehicles that arrive form a single queue, and then proceed to pump 1. If pump 2 is open and free then vehicles will go to pump 2.  
 
Display the information for each vehicle that is serviced in the queue using a text area within your GUI. Make sure that you accumulate enough information in order to be able to display the summary. 
 
For each unit of time, the probability that a vehicle will arrive is 45%. The service time for each vehicle has a 65% chance of being 3 units of time, and a 35% chance of being 5 units of time. Run the simulation for 2 hours (120 units of time). At the end of 2 hours, a summary as illustrated below is to be printed. 
 
Possible Output: 
 
Vehicle number 1 arrived at time unit 6 Vehicle 1 served at time unit 6 at pump 1 Vehicle number 2 arrived at time unit 7 Vehicle 2 served at time unit 12 at pump 1 ... .... *** Simulation Summary *** Simulation ran for 120 units of time Average serving time: ?? Average arrival time difference between vehicles: ?? Longest time that a vehicle waited: ?? Vehicles served at pump 1: ?? Vehicles served at pump 2: ?? Total number of vehicles served: ?? Number of vehicles left in the queue: ?? Average wait time per vehicle: ?? *** End of Report ***
