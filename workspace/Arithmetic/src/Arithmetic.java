import java.util.Scanner;

public class Arithmetic
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);

      System.out.println();
      System.out.print("First number: ");
      double d1 = input.nextDouble();

      System.out.print("Second number: ");
      double d2 = input.nextDouble();

      System.out.println();
      System.out.println(d1 + " + " + d2 + " = " + (d1 + d2));
      System.out.println(d1 + " - " + d2 + " = " + (d1 - d2));
      System.out.println(d1 + " * " + d2 + " = " + (d1 * d2));
      System.out.println(d1 + " / " + d2 + " = " + (d1 / d2));
   }
}
