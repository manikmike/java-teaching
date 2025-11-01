import java.io.*;
import java.util.*;

public class Request
{
   public static Request[] readFile(String fileName)
   {
      ArrayList<Request> requestList = new ArrayList<Request>();
      try
      {
         BufferedReader requestFile = new BufferedReader(new FileReader(fileName));
         String line = requestFile.readLine();  // header file
         while ((line=requestFile.readLine()) != null)
         {
            String[] splitLine = line.split(",");
            int startTime = Integer.valueOf(splitLine[0]);
            int startFloor = Integer.valueOf(splitLine[1]);
            int endFloor = Integer.valueOf(splitLine[2]);
            Request request = new Request(startTime, startFloor, endFloor);
            requestList.add(request);
         }
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      return (Request[]) requestList.toArray(new Request[requestList.size()]);
   }
   
   public Request(int startTime, int startFloor, int endFloor)
   {
      this.setStartTime(startTime);
      this.setStartFloor(startFloor);
      this.setEndFloor(endFloor);
   }
   
   public int getStartTime()
   {
      return startTime;
   }
   
   public void setStartTime(int startTime)
   {
      this.startTime = startTime;
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
   private int startFloor;
   private int endFloor;
}
