import java.util.Scanner;
public class ConeCalculator implements Calculator
{
    public double calculateBaseArea()
    {
        Scanner typed = new Scanner(System.in);
        System.out.println("Podaj dlugosc promienia podstawy");
    double r = typed.nextDouble();
    double area = Math.pow(r,2)*Math.PI;
    return area;
    }
   public double calculateBasePerimeter()
   {
       Scanner typed = new Scanner(System.in);
       System.out.println("Podaj dlugosc promienia podstawy");
       double r = typed.nextDouble();
       double perimeter = 2*r*Math.PI;
       return perimeter;
   }
}
