import java.util.*;

public class Simulation
{
   public static void main(String args[])
   {
      Building building = new Building(4, 100);  // 4 elevators, 100 floors
      Request[] request = Request.readFile("Elevator.csv");
      ArrayList<Passenger> results = new ArrayList<Passenger>();

      int i = 0;
      int numRequests = request.length;

      for (int time = 0; time < 36855; time++)
      {
         while (i < numRequests && time == request[i].getStartTime())
         {
            Passenger p = new Passenger(request[i]);
            building.addPassenger(p);
            results.add(p);
            i++;
         }
         System.out.println(time);
         building.printElevators();
         // increment all elevators by 1 second
         building.moveElevators(time);
         System.out.println();
      }
      
      int averageWaitTime = 0;
      int averageTravelTime = 0;
      for (Passenger p : results)
      {
         System.out.println(p.getStartTime() + " " + p.getPickUpTime() + " " + p.getEndTime());
         averageWaitTime += p.getWaitTime();
         averageTravelTime += p.getTravelTime();
      }
      averageWaitTime  /= results.size();
      averageTravelTime /= results.size();
      
      System.out.println();
      System.out.println("Average Wait Time: " + averageWaitTime + " s");
      System.out.println("Average Travel Time: " + averageTravelTime + " s");
   }
}
