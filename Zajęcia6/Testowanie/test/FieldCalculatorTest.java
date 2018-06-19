import org.junit.*;

import static org.junit.Assert.*;

public class FieldCalculatorTest {

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
    public void calculateSquare() {

        assertEquals(FieldCalculator.calculateSquare(2), 4,0);
        assertEquals(FieldCalculator.calculateSquare(3), 9,0);
        assertEquals(FieldCalculator.calculateSquare(4),16,0);
    }

    @Test
    public void calculateCircle() {
        assertEquals(FieldCalculator.calculateCircle(2),Math.PI * 4,0);
        assertEquals(FieldCalculator.calculateCircle(3),Math.PI * 9,0);
        assertEquals(FieldCalculator.calculateCircle(4),Math.PI * 16,0);
    }

    @Test
    public void calculateTriangle() {
        assertEquals(FieldCalculator.calculateTriangle(2,3),3,0);
        assertEquals(FieldCalculator.calculateTriangle(4,8),16,0);
        assertEquals(FieldCalculator.calculateTriangle(10,10),50,0);
    }

    @Test
    public void calculateRectangle() {
        assertEquals(FieldCalculator.calculateRectangle(2,3),6,0);
        assertEquals(FieldCalculator.calculateRectangle(4,8),32,0);
        assertEquals(FieldCalculator.calculateRectangle(10,10),100,0);
    }
}