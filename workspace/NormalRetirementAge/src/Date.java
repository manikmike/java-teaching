public class Date
{
   private int month;
   private int day;
   private int year;
   
   public Date(int month, int day, int year)
   {
      this.setMonth(month);
      this.setDay(day);
      this.setYear(year);
   }
   
   public void display()
   {
      System.out.printf("%d/%d/%d\n", month, day, year);
   }
   
   public int getMonth()
   {
      return month;
   }
   
   public void setMonth(int month)
   {
      if (month < 1) month = 1;
      else if (month > 12) month = 12;
      this.month = month;
   }
   
   public int getDay()
   {
      return day;
   }
   
   public void setDay(int day)
   {
      if (day < 1) day = 1;
      else if (day > 31) day = 31;
      this.day = day;
   }
   
   public int getYear()
   {
      return year;
   }
   
   public void setYear(int year)
   {
      if (year < 0) year = 0;
      this.year = year;
   }
}
