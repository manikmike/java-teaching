import java.util.*;

public class Floor
{
    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int IDLE = 2;
    
    private int number;
    private boolean[] button = new boolean[2];
    private boolean[] display = new boolean[2];
    private ArrayList<Passenger> waiting;
    
    public Floor(int number)
    {
       this.number = number;
       waiting = new ArrayList<Passenger>();
    }
    
    public void addPassenger(Passenger p)
    {
       waiting.add(p);
    }
    
    public void removePassenger(Passenger p)
    {
       waiting.remove(p);
    }
    
    public void pushButton(int direction)
    {
       switch (direction)
       {
       case UP:
          this.button[UP] = true;
          break;
       case DOWN:
          this.button[DOWN] = false;
          break;
       }
    }
    
    public int getNumber()
    {
       return this.number;
    }
    
    public ArrayList<Passenger> getWaiting()
    {
       return waiting;
    }
    
    public void updateDisplay(int direction)
    {
       switch(direction)
       {
       case UP:
          this.display[UP] = true;
          this.display[DOWN] = false;
          break;
       case DOWN:
          this.display[UP] = false;
          this.display[DOWN] = true;
          break;
       case IDLE:
       default:
          this.display[UP] = false;
          this.display[DOWN] = false;
       }
    }
    
    public void clearDisplay()
    {
       this.display[UP] = false;
       this.display[DOWN] = false;
    }
}
