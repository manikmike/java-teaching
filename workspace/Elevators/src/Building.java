import java.util.*;

public class Building
{
   public Building(int numElevators, int numFloors)
   {
      this.numElevators = numElevators;
      this.numFloors = numFloors;
      elevator = new Elevator[numElevators];
      for (int i=0; i < numElevators; i++)
      {
         elevator[i] = new Elevator(numFloors);
      }
      floor = new Floor[numFloors+1];
      for (int i=0; i < numFloors+1; i++)
      {
         floor[i] = new Floor(i);
      }
   }
   
   public void addPassenger(Passenger p)
   {
      int startFloor = p.getStartFloor();
      floor[startFloor].addPassenger(p);
      p.callElevator(floor[startFloor]);
      if (p.getEndFloor() >= p.getStartFloor())
      {
         Elevator.addCall(startFloor);         
      }
      else
      {
         Elevator.addCall(-p.getStartFloor());
      }
   }
   
   public void moveElevators(int time)
   {
      for (int i=0; i < elevator.length; i++)
      {
         elevator[i].move(time, floor[elevator[i].getCurrentFloor()]);
      }
   }
   
   public void printElevators()
   {
      for (int i=0; i < elevator.length; i++)
      {
         System.out.print((i+1) + ":" + elevator[i].getCurrentFloor() + " ");
      }
      System.out.println();

      for (int i=0; i < elevator.length; i++)
      {
         System.out.print((i+1) + ":" + elevator[i].getState() + " ");
      }
      System.out.println();
   }
   
   public void printFloors()
   {
      for (int i=floor.length-1; i >= 0; i--)
      {
         System.out.println(i + ":");
         ArrayList<Passenger> waiting = floor[i].getWaiting();
         for (Passenger p : waiting)
         {
            System.out.println("   " + p);
         }
      }
   }
   
   private int numElevators;
   private int numFloors;
   private Elevator[] elevator;
   private Floor[] floor;
}
