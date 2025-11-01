public class Passenger
{
   public Passenger(Request request)
   {
      this.startTime = request.getStartTime();
      this.startFloor = request.getStartFloor();
      this.endFloor = request.getEndFloor();
   }
   
   public int getWaitTime()
   {
      return (pickUpTime - startTime);
   }
   
   public int getTravelTime()
   {
      return (endTime - pickUpTime);
   }
   
   public void callElevator(Floor floor)
   {
      if (this.goingUp())
        floor.pushButton(Floor.UP);
      else if (this.goingDown())
         floor.pushButton(Floor.DOWN);
   }
   
   public boolean pushButton()
   {
      return true;
   }
   
   public boolean goingUp()
   {
      if (this.endFloor > this.startFloor) return true;
      else return false;
   }
   
   public boolean goingDown()
   {
      if (this.endFloor < this.startFloor) return true;
      else return false;
   }
   
   public int getStartTime()
   {
      return startTime;
   }

   public void setStartTime(int startTime)
   {
      this.startTime = startTime;
   }

   public int getPickUpTime()
   {
      return pickUpTime;
   }

   public void setPickUpTime(int pickUpTime)
   {
      this.pickUpTime = pickUpTime;
   }

   public int getEndTime()
   {
      return endTime;
   }

   public void setEndTime(int endTime)
   {
      this.endTime = endTime;
   }

   public int getStartFloor()
   {
      return startFloor;
   }

   public void setStartFloor(int startFloor)
   {
      this.startFloor = startFloor;
   }

   public int getEndFloor()
   {
      return endFloor;
   }

   public void setEndFloor(int endFloor)
   {
      this.endFloor = endFloor;
   }

   private int startTime;
   private int pickUpTime;
   private int endTime;
   private int startFloor;
   private int endFloor;
}
