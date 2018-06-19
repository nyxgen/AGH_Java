import java.util.Scanner;

public class ExtendedConeCalculator extends  ConeCalculator
{
   void calculateArea() throws Exception
    {
        Scanner typed = new Scanner(System.in);
        System.out.println("Podaj dlugosc promienia podstawy");
        double r = typed.nextDouble();
        if(r<=0)
        {
            throw new IllegalArgumentException("Podano niepoprawny argument");
        }
        System.out.println("Podaj dlugosc wysokosci");
        double h = typed.nextDouble();
        if(h<=0)
        {
            throw new IllegalArgumentException("Podano niepoprawny argument");
        }
        double area = Math.pow(r,2)*Math.PI + Math.sqrt(Math.pow(r,2)+Math.pow(h,2))*2*Math.PI*r;
        System.out.println(area);
    }
    void calculateVolume() throws Exception
    {
        Scanner typed = new Scanner(System.in);
        System.out.println("Podaj dlugosc promienia podstawy");
        double r = typed.nextDouble();
        if(r<=0)
        {
            throw new IllegalArgumentException("Podano niepoprawny argument");
        }
        System.out.println("Podaj dlugosc wysokosci");
        double h = typed.nextDouble();
        if(h<=0)
        {
            throw new IllegalArgumentException("Podano niepoprawny argument");
        }
        double volume  =  Math.pow(r,2)*Math.PI*h/3;
        System.out.println(volume);
    }
}
