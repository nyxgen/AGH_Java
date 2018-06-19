public class BasicCalculator {
   public static double calculateSum(double first, double second)
    {
        return first + second;
    }
    public static double calculateDifference(double first, double second)
    {
        return first - second;
    }
    public static double calculateMultiplication(double first, double second)
    {
        return first * second;
    }
    public static double calculateDivision(double first, double second)
    {
        if(second == 0)
            throw new IllegalArgumentException("Dzielenie przez 0");
        return first / second;
    }
    public static double calculatePow(double first, double second)
    {
        return Math.pow(first, second);
    }
    public static double calculateSqrt(double first)
    {
        if( first < 0)
            throw new IllegalArgumentException("Pierwiastkowanie liczby ujemnej");
        return Math.sqrt(first);
    }

}
