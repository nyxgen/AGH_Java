public class FieldCalculator {
    public static double calculateSquare(double a)
    {
        if(a <= 0)
            throw new IllegalArgumentException("Bok mniejszy od 0");
        return Math.pow(a,2);
    }
    public static double calculateCircle(double r)
    {
        if(r <= 0)
            throw new IllegalArgumentException("Promień mniejszy od 0");
        return Math.PI*Math.pow(r,2);
    }
    public static double calculateTriangle(double a, double h)
    {
        if(a <= 0)
            throw new IllegalArgumentException("Bok mniejszy od 0");
        if(h <= 0)
            throw new IllegalArgumentException("Wysokość mniejsza od 0");
        return a*h/2;
    }
    public static double calculateRectangle(double a, double b)
    {
        if(a <= 0)
            throw new IllegalArgumentException("Bok a mniejszy od 0");
        if(b <= 0)
            throw new IllegalArgumentException("Bok b mniejszy od 0");
        return a*b;
    }
}
