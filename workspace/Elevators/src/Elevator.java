import java.util.*;

public class Elevator
{
   public static final int STOPPED = 0;
   public static final int STOPPING = 1;
   public static final int MOVING_UP = 2;
   public static final int MOVING_DOWN = 3;
   
   public static final int STOPPING_TIME = 2;
   public static final int FLOOR_TIME = 10;
   public static final int MAX_PASSENGERS = 8;
   
   public Elevator(int numFloors)
   {
      this.traveling = new ArrayList<Passenger>();
      this.number = ++count;
      this.button = new boolean[numFloors+1];
   }
   
   public void move(int time, Floor floor)
   {
      System.out.println(this.getNextFloor() + " " + this.getCurrentFloor());
      switch (this.state)
      {
      case STOPPED:
         // Dispatch an idle elevator
         if (this.getNextFloor() == -1 && call.size() > 0)
         {
            Integer nextCall = call.remove(0);
            if (nextCall != null)
            {
               this.button[Math.abs(nextCall)] = true; 
               if (this.goingUp())
                  this.state = MOVING_UP;
               else if (this.goingDown())
                  this.state = MOVING_DOWN;
            }
            break;
         }
         // Turn off the inside button for this floor
         this.button[currentFloor] = false;
         // Update the outside direction display
         floor.updateDisplay(getDirection());
         // Passengers exit elevator here
         ArrayList<Passenger> temp = new ArrayList<Passenger>();
         temp.addAll(traveling);
         for (Passenger p : temp)
         {
            if (p.getEndFloor() == this.currentFloor)
            {
               p.setEndTime(time);
               traveling.remove(p);
               System.out.println("Passenger " + p.getStartTime() +
                        " is leaving elevator " + this.number);
            }
         }
         // Passengers enter elevator here
         int currentFloor = this.getCurrentFloor();
         temp = new ArrayList<Passenger>(); 
         temp.addAll(floor.getWaiting());
         // Add the first passenger
         if (temp.size() > 0)
         {
            Passenger p = temp.remove(0);
            if (this.isIdle() ||
                p.goingUp() && this.goingUp() ||
                p.goingDown() && this.goingDown())
            {
               this.addPassenger(p);
               p.setPickUpTime(time);
               this.button[p.getEndFloor()] = p.pushButton();
               floor.removePassenger(p);
            }
         }
         // Add the rest of the passengers
         for (Passenger p : temp)
         {
            if (this.isIdle() ||
                p.goingUp() && this.goingUp() ||
                p.goingDown() && this.goingDown())
            {
               this.addPassenger(p);
               p.setPickUpTime(time);
               this.button[p.getEndFloor()] = p.pushButton();
               floor.removePassenger(p);
            }
         }
         // Set the elevator in motion again
         if (this.goingUp())
            this.state = MOVING_UP;
         else if (this.goingDown())
            this.state = MOVING_DOWN;
         // Clear the outside direction display
         floor.clearDisplay();
         break;
      case STOPPING:
         this.timeToStop--;
         if (this.timeToStop == 0)
         {
            this.state = STOPPED;
            this.timeToStop = STOPPING_TIME;
         }
         break;
      case MOVING_UP:
         this.timeToFloor--;
         if (this.timeToFloor == 0)
         {
            this.currentFloor++;
            this.timeToFloor = FLOOR_TIME;
            if (this.getCurrentFloor() == this.getNextFloor())
            {
               this.state = STOPPING;
            }
         }
         break;
      case MOVING_DOWN:
         this.timeToFloor--;
         if (this.timeToFloor == 0)
         {
            this.currentFloor--;
            this.timeToFloor = FLOOR_TIME;
            if (this.getCurrentFloor() == this.getNextFloor())
            {
               this.state = STOPPING;
            }
         }
         break;
      }
      

   }
   
   public int getState()
   {
      return state;
   }

   public void setState(int state)
   {  
      this.state = state;
   }

   public int getCurrentFloor()
   {
      return currentFloor;
   }

   public void setCurrentFloor(int currentFloor)
   {
      this.currentFloor = currentFloor;
   }
   
   public int getNextFloor()
   {
      int numFloors = this.button.length-1;
      int min = numFloors+1;
      int max = -1;
      int nextFloor = -1;
      
      // Lowest floor button pressed or numFloors+1 if none
      for (int i=min; i > 0; i--)
      {
         if (button[i-1])
         {
            min = i-1;
         }
      }
      
      // Highest floor button pressed or -1 if none
      for (int i=max; i < numFloors; i++)
      {
         if (button[i+1])
         {
            max = i+1;
         }
      }
      
      if (min == numFloors+1 && max == -1)  // elevator is idle
      {
         nextFloor = -1;
      }
      else if(currentFloor < min && min != numFloors+1)  // elevator is going up
      {
         nextFloor = min;
      }
      else if(currentFloor > max && max != -1)  // elevator is going down
      {
         nextFloor = max;
      }
      else if (min == currentFloor || max == currentFloor)  // elevator has reached destination
      {
         nextFloor = currentFloor;
      }
      
      return nextFloor;
   }

   public static void addCall(int c)
   {
      if (!call.contains(c))
      {
         call.add(c);
      }
   }

   public void addPassenger(Passenger p)
   {
      System.out.println("Passenger " + p.getStartTime() +
         " is entering elevator " + this.number);
      traveling.add(p);
   }
   
   public boolean goingUp()
   {
      int nextFloor = this.getNextFloor();
      if (nextFloor == -1)
         return false;
      else if (currentFloor <  nextFloor)
         return true;
      else
         return false;
   }
   
   public boolean goingDown()
   {
      int nextFloor = this.getNextFloor();
      if (nextFloor == -1)
         return false;
      else if (currentFloor >  nextFloor)
         return true;
      else
         return false;
   }
   
   public boolean isIdle()
   {
      return (!goingUp() && !goingDown());
   }
   
   public int getDirection()
   {
      if (this.goingUp())
         return Floor.UP;
      else if (this.goingDown())
         return Floor.DOWN;
      else
         return Floor.IDLE;
   }
  
   private int number;
   private static int count;
   private int state;
   private int currentFloor;
   //private Floor floor;
   private ArrayList<Passenger> traveling;
   private static ArrayList<Integer> call = new ArrayList<Integer>();
   private boolean[] button;
   private int timeToStop = Elevator.STOPPING_TIME;
   private int timeToFloor = Elevator.FLOOR_TIME;
}
