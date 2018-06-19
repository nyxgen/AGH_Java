import java.util.Scanner;

public class ExtendedTetrahedronCalculator extends TetrahedronCalculator
{
    void calculateArea() throws  Exception
    {
        Scanner typed = new Scanner(System.in);
        System.out.println("Podaj dlugosc boku podstawy");
        double a = typed.nextDouble();
        if(a<=0)
        {
            throw new IllegalArgumentException("Podano niepoprawny argument");
        }
        double area = Math.pow(a,2)*Math.sqrt(3)*2;
        System.out.println(area);
    }
    void calculateVolume() throws Exception
    {
        Scanner typed = new Scanner(System.in);
        System.out.println("Podaj dlugosc promienia podstawy");
        double a = typed.nextDouble();
        if(a<=0)
        {
            throw new IllegalArgumentException("Podano niepoprawny argument");
        }
        double volume  =  Math.pow(a,2)*Math.sqrt(3)/6 * Math.sqrt(Math.pow(a,2)-Math.pow(2*a/3,2));
        System.out.println(volume);
    }
}
