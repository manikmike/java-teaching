public class Complex
{
   private double real;
   private double imaginary;
   
   /** The complex number (0,0) */
   public static final Complex ZERO = new Complex(0,0);
   
   /** The complex number (1,0) */
   public static final Complex ONE = new Complex(1,0);
   
   /** The square root of -1; the complex number (0,1)*/
   public static final Complex I = new Complex(0,1);

   /** Initialize both parts to 0 */
   public Complex()
   { 
      this(0,0);
   }

   /** Initialize the real and imaginary parts */
   public Complex(double real, double imaginary)
   {
      this.real = real;
      this.imaginary = imaginary;
   }
   
   /** Create a Complex number from polar form */
   public static Complex fromPolar(double abs, double arg)
   {
      return new Complex(abs * Math.cos(arg), abs * Math.sin(arg));
   }
   
   /** Create a Complex number from rectangular form */
   public static Complex fromRectangular(double real, double imaginary)
   {
      return new Complex(real, imaginary);
   }

   /** Return the real part of this complex number */
   public double getReal()
   {
      return real;
   }

   /** Set the real part of this complex number */
   public void setReal(double real)
   {
      this.real = real;
   }


   /** Return the imaginary part of this complex number */
   public double getImaginary()
   {
      return imaginary;
   }

   /** Set the imaginary part of this complex number */
   public void setImaginary(double imaginary)
   {
      this.imaginary = imaginary;
   }


   /** Add two Complex numbers */
   public Complex add(Complex right)
   {
      return new Complex(this.real + right.real, 
                         this.imaginary + right.imaginary);    
   }

   /** Subtract two Complex numbers */
   public Complex subtract(Complex right)
   {
      return new Complex(this.real - right.real, 
                         this.imaginary - right.imaginary);    
   }
   
   /** Multiply two Complex numbers */
   public Complex multiply(Complex right)
   {
      double a = this.real;
      double b = this.imaginary;
      double c = right.real;
      double d = right.imaginary;
      return new Complex(a * c - b * d,
                         a * d + b * c);    
   }

   /** Divide two Complex numbers */
   public Complex divide(Complex right)
   {
      double a = this.real;
      double b = this.imaginary;
      double c = right.real;
      double d = right.imaginary;
      double denom = c * c + d * d;
      return new Complex((a * c + b * d) / denom,
                         (b * c - a * d) / denom);   
   }
   
   /** Return the absolute value of a Complex number (aka, modulus or magnitude) */
   public double abs()
   {
      return Math.sqrt(this.real * this.real +
                       this.imaginary * this.imaginary);
   }
   
   /** Return the argument of a Complex number (aka, phase or angle) */
   public double arg()
   {
      return Math.atan2(this.imaginary, this.real);
   }
   
   /** Return the complex conjugate of a Complex number */
   public Complex conjugate()
   {
      return new Complex(this.real, -this.imaginary);
   }
   
   /** Returns true if obj is an instance of Complex with obj.real = this.real
    *  and obj.imaginary = this.imaginary
    */
   public boolean equals(Object obj)
   {
      if (obj == null || !(obj instanceof Complex)) return false;
      if (this.real == ((Complex) obj).real &&
          this.imaginary == ((Complex) obj).imaginary) return true;
      else return false;
   }
   
   /** Return String representation of a Complex number in Polar Form */
   public String toPolarString() 
   { 
      return String.format("%.4f < %.4f", this.abs(), this.arg());
   }
   

   /** Return String representation of a Complex number */
   public String toString() 
   { 
      return String.format("(%.4f, %.4f)", real, imaginary);
   }
}
