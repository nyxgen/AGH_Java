import org.junit.*;

import static org.junit.Assert.*;

public class BasicCalculatorTest {

    @BeforeClass
    public static void testStartMessage() {
        System.out.println("Start testu");
        System.out.println();
    }

    @Before
    public void unitTestStartMessage(){
        System.out.println("Start testu jednostkowego");
    }

    @AfterClass
    public static void testEndMessage() {
        System.out.println("Koniec testu");
    }

    @After
    public void unitTestEndMessage() {
        System.out.println("Koniec testu jednostkowego");
        System.out.println();
    }


    @Test
    public void calculateSum() {
        assertEquals(BasicCalculator.calculateSum(2,2),3,0);
        assertEquals(BasicCalculator.calculateSum(-10,1),-9,0);
        assertEquals(BasicCalculator.calculateSum(10,-5),5,0);

    }

    @Test
    public void calculateDifference() {
        assertEquals(BasicCalculator.calculateDifference(2,2),0,0);
        assertEquals(BasicCalculator.calculateDifference(-10,1),-11,0);
        assertEquals(BasicCalculator.calculateDifference(10,-5),15,0);
    }

    @Test
    public void calculateMultiplication() {
        assertEquals(BasicCalculator.calculateMultiplication(2,2),4,0);
        assertEquals(BasicCalculator.calculateMultiplication(-10,1),-10,0);
        assertEquals(BasicCalculator.calculateMultiplication(10,-5),-50,0);
    }

    @Test
    public void calculateDivision() {
        assertEquals(BasicCalculator.calculateDivision(2,2),1,0);
        assertEquals(BasicCalculator.calculateDivision(-10,1),-10,0);
        assertEquals(BasicCalculator.calculateDivision(10,-5),-2,0);
    }

    @Test
    public void calculatePow() {
        assertEquals(BasicCalculator.calculatePow(2,2),4,0);
        assertEquals(BasicCalculator.calculatePow(-10,1),-10,0);
        assertEquals(BasicCalculator.calculatePow(10,-5),Math.pow(10,-5),0);
    }

    @Test
    public void calculateSqrt() {
        assertEquals(BasicCalculator.calculateSqrt(2),Math.sqrt(2),0);
        assertEquals(BasicCalculator.calculateSqrt(16),4,0);
        assertEquals(BasicCalculator.calculateSqrt(10), Math.sqrt(10),0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void calculateDivisionException(){
        BasicCalculator.calculateDivision(4,0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void calculateSqrtException(){
        BasicCalculator.calculateSqrt(-2);
    }

}