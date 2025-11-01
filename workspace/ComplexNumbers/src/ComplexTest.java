public class ComplexTest
{
   public static void main(String args[])
   {
      // initialize two numbers
      Complex a = new Complex(9.5, 7.7);
      Complex b = new Complex(1.2, 3.1);
      Complex c = new Complex(9.5, 7.7);
 
      System.out.printf("a = %s\n", a);
      System.out.printf("a polar = %s\n", a.toPolarString());
      System.out.printf("? = %s\n", Complex.fromPolar(10, Math.PI/4));
      System.out.printf("?? = %s\n", new Complex(-10,0).toPolarString());
      System.out.printf("b = %s\n", b);
      System.out.printf("a + b = %s\n", a.add(b));
      System.out.printf("a - b = %s\n", a.subtract(b));
      System.out.printf("c = %s\n", c);
      System.out.printf("a == c = %s\n", a == c);
      System.out.printf("a.equals(c) = %s\n",a.equals(c));
      System.out.printf("a * b = %s\n", a.multiply(b));
      System.out.printf("a / b = %s\n", a.divide(b));
      System.out.printf("i * i = %s\n", Complex.I.multiply(Complex.I));
   }
}
