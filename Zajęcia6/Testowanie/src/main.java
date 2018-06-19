
public class main {
    public static void main(String args[])
    {
       try
        {
            System.out.println(FieldCalculator.calculateCircle(2));
        }
       catch(IllegalArgumentException exception)
        {
            System.out.println(exception.getMessage());
        }
    }
}
