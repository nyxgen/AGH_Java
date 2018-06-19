import java.util.Scanner;

public class TetrahedronCalculator implements Calculator
{

    public double calculateBaseArea()
    {
        Scanner typed = new Scanner(System.in);
        System.out.println("Podaj dlugosc boku podstawy");
        double a = typed.nextDouble();
        double area = Math.pow(a,2)*Math.sqrt(3)/2;
        return area;
    }
    public double calculateBasePerimeter()
    {
        Scanner typed = new Scanner(System.in);
        System.out.println("Podaj dlugosc boku podstawy");
        double a = typed.nextDouble();
        double perimeter = 3*a;
        return perimeter;
    }
}
