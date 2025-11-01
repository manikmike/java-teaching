public class NormalRetirementAge
{
   public static void compute(Date birthDate)
   {
      int year = birthDate.getYear();
      int month = birthDate.getMonth();
      int day = birthDate.getDay();
      
      if (month == 1 && day == 1) year--;
      
      if (year <= 1937)
         System.out.println("65");
      else if (year == 1938)
         System.out.println("65 and 2 months");
      else if (year == 1939)
         System.out.println("65 and 4 months");
      else if (year == 1940)
         System.out.println("65 and 6 months");
      else if (year == 1941)
         System.out.println("65 and 8 months");
      else if (year == 1942)
         System.out.println("65 and 10 months");
      else if (year >= 1943 && year <= 1954)
         System.out.println("66");
      else if (year == 1955)
         System.out.println("66 and 2 months");
      else if (year == 1956)
         System.out.println("66 amd 4 months");
      else if (year == 1957)
         System.out.println("66 and 6 months");
      else if (year == 1958)
         System.out.println("66 and 8 months");
      else if (year == 1959)
         System.out.println("66 amd 10 months");
      else // (year >= 1960)
         System.out.println("67");
   }
   
   public static void main(String args[])
   {
      Date birthDate = new Date(12,7,1941);
      
      System.out.print("Your birthdate is: ");
      birthDate.display();
      
      System.out.print("Your normal retirement age is: ");
      NormalRetirementAge.compute(birthDate);
   }
}
