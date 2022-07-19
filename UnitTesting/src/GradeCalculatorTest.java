import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.Grade;
import util.GradeFactory;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GradeCalculatorTest {
    private static Random random;
    private static final int TEST_CASES = 10000;
    private static Grade threeCreditGrade;
    private static Grade fourCreditGrade;

    @BeforeAll
    public static void setup() {
        random = new Random(1805010);
        threeCreditGrade = GradeFactory.getGrades(3);
        fourCreditGrade = GradeFactory.getGrades(4);
    }

    @Test
    @DisplayName("Grade A test for 3 credit course")
    public void gradeAThree() {
        for (int i = 0; i < TEST_CASES; i++) {
            double mark = threeCreditGrade.ALow +
                    random.nextDouble() * (threeCreditGrade.AHigh - threeCreditGrade.ALow);
            String markString = Double.toString(mark);
            assertEquals('A', GradeCalculator.calculateGrade(markString, "3"));
        }
    }

    @Test
    @DisplayName("Grade A boundary test for 3 credit course")
    public void gradeAThreeBoundary() {
        for (int i = 0; i < TEST_CASES; i++) {
            double mark = threeCreditGrade.AHigh - random.nextDouble();
            String markString = Double.toString(mark);
            assertEquals('A', GradeCalculator.calculateGrade(markString, "3"));
        }
        for (int i = 0; i < TEST_CASES; i++) {
            double mark = threeCreditGrade.ALow - random.nextDouble();
            String markString = Double.toString(mark);
            assertEquals('A', GradeCalculator.calculateGrade(markString, "3"));
        }
    }

    @Test
    @DisplayName("Grade B test for 3 credit course")
    public void gradeBThree() {
        for (int i = 0; i < TEST_CASES; i++) {
            double mark = threeCreditGrade.BLow +
                    random.nextDouble() * (threeCreditGrade.BHigh - threeCreditGrade.BLow);
            String markString = Double.toString(mark);
            assertEquals('B', GradeCalculator.calculateGrade(markString, "3"));
        }
    }

    @Test
    @DisplayName("Grade B boundary test for 3 credit course")
    public void gradeBThreeBoundary() {
        for (int i = 0; i < TEST_CASES; i++) {
            double mark = threeCreditGrade.BHigh - random.nextDouble();
            String markString = Double.toString(mark);
            assertEquals('B', GradeCalculator.calculateGrade(markString, "3"));
        }
        for (int i = 0; i < TEST_CASES; i++) {
            double mark = threeCreditGrade.BLow - random.nextDouble();
            String markString = Double.toString(mark);
            assertEquals('B', GradeCalculator.calculateGrade(markString, "3"));
        }
    }

    @Test
    @DisplayName("Grade C test for 3 credit course")
    public void gradeCThree() {
        for (int i = 0; i < TEST_CASES; i++) {
            double mark = threeCreditGrade.CLow +
                    random.nextDouble() * (threeCreditGrade.CHigh - threeCreditGrade.CLow);
            String markString = Double.toString(mark);
            assertEquals('C', GradeCalculator.calculateGrade(markString, "3"));
        }
    }

    @Test
    @DisplayName("Grade C boundary test for 3 credit course")
    public void gradeCThreeBoundary() {
        for (int i = 0; i < TEST_CASES; i++) {
            double mark = threeCreditGrade.CHigh - random.nextDouble();
            String markString = Double.toString(mark);
            assertEquals('C', GradeCalculator.calculateGrade(markString, "3"));
        }
        for (int i = 0; i < TEST_CASES; i++) {
            double mark = threeCreditGrade.CLow - random.nextDouble();
            String markString = Double.toString(mark);
            assertEquals('C', GradeCalculator.calculateGrade(markString, "3"));
        }
    }

    @Test
    @DisplayName("Grade F test for 3 credit course")
    public void gradeFThree() {
        for (int i = 0; i < TEST_CASES; i++) {
            double mark = threeCreditGrade.FLow +
                    random.nextDouble() * (threeCreditGrade.FHigh - threeCreditGrade.FLow);
            String markString = Double.toString(mark);
            assertEquals('F', GradeCalculator.calculateGrade(markString, "3"));
        }
    }

    @Test
    @DisplayName("Grade F boundary test for 3 credit course")
    public void gradeFThreeBoundary() {
        for (int i = 0; i < TEST_CASES; i++) {
            double mark = threeCreditGrade.FHigh - random.nextDouble();
            String markString = Double.toString(mark);
            assertEquals('F', GradeCalculator.calculateGrade(markString, "3"));
        }
        for (int i = 0; i < TEST_CASES; i++) {
            double mark = threeCreditGrade.FLow + random.nextDouble();
            String markString = Double.toString(mark);
            assertEquals('F', GradeCalculator.calculateGrade(markString, "3"));
        }
    }

    @Test
    @DisplayName("Grade A test for 4 credit course")
    public void gradeAFour() {
        for (int i = 0; i < TEST_CASES; i++) {
            double mark = fourCreditGrade.ALow +
                    random.nextDouble() * (fourCreditGrade.AHigh - fourCreditGrade.ALow);
            String markString = Double.toString(mark);
            assertEquals('A', GradeCalculator.calculateGrade(markString, "4"));
        }
    }

    @Test
    @DisplayName("Grade A boundary test for 4 credit course")
    public void gradeAFourBoundary() {
        for (int i = 0; i < TEST_CASES; i++) {
            double mark = fourCreditGrade.AHigh - random.nextDouble();
            String markString = Double.toString(mark);
            assertEquals('A', GradeCalculator.calculateGrade(markString, "4"));
        }
        for (int i = 0; i < TEST_CASES; i++) {
            double mark = fourCreditGrade.ALow - random.nextDouble();
            String markString = Double.toString(mark);
            assertEquals('A', GradeCalculator.calculateGrade(markString, "4"));
        }
    }

    @Test
    @DisplayName("Grade B test for 4 credit course")
    public void gradeBFour() {
        for (int i = 0; i < TEST_CASES; i++) {
            double mark = fourCreditGrade.BLow +
                    random.nextDouble() * (fourCreditGrade.BHigh - fourCreditGrade.BLow);
            String markString = Double.toString(mark);
            assertEquals('B', GradeCalculator.calculateGrade(markString, "4"));
        }
    }

    @Test
    @DisplayName("Grade B boundary test for 4 credit course")
    public void gradeBFourBoundary() {
        for (int i = 0; i < TEST_CASES; i++) {
            double mark = fourCreditGrade.BHigh - random.nextDouble();
            String markString = Double.toString(mark);
            assertEquals('B', GradeCalculator.calculateGrade(markString, "4"));
        }
        for (int i = 0; i < TEST_CASES; i++) {
            double mark = fourCreditGrade.BLow - random.nextDouble();
            String markString = Double.toString(mark);
            assertEquals('B', GradeCalculator.calculateGrade(markString, "4"));
        }
    }

    @Test
    @DisplayName("Grade C test for 4 credit course")
    public void gradeCFour() {
        for (int i = 0; i < TEST_CASES; i++) {
            double mark = fourCreditGrade.CLow +
                    random.nextDouble() * (fourCreditGrade.CHigh - fourCreditGrade.CLow);
            String markString = Double.toString(mark);
            assertEquals('C', GradeCalculator.calculateGrade(markString, "4"));
        }
    }

    @Test
    @DisplayName("Grade C boundary test for 4 credit course")
    public void gradeCFourBoundary() {
        for (int i = 0; i < TEST_CASES; i++) {
            double mark = fourCreditGrade.CHigh - random.nextDouble();
            String markString = Double.toString(mark);
            assertEquals('C', GradeCalculator.calculateGrade(markString, "4"));
        }
        for (int i = 0; i < TEST_CASES; i++) {
            double mark = fourCreditGrade.CLow - random.nextDouble();
            String markString = Double.toString(mark);
            assertEquals('C', GradeCalculator.calculateGrade(markString, "4"));
        }
    }

    @Test
    @DisplayName("Grade F test for 4 credit course")
    public void gradeFFour() {
        for (int i = 0; i < TEST_CASES; i++) {
            double mark = fourCreditGrade.FLow +
                    random.nextDouble() * (fourCreditGrade.FHigh - fourCreditGrade.FLow);
            String markString = Double.toString(mark);
            assertEquals('F', GradeCalculator.calculateGrade(markString, "4"));
        }
    }

    @Test
    @DisplayName("Grade F boundary test for 4 credit course")
    public void gradeFFourBoundary() {
        for (int i = 0; i < TEST_CASES; i++) {
            double mark = fourCreditGrade.FHigh - random.nextDouble();
            String markString = Double.toString(mark);
            assertEquals('F', GradeCalculator.calculateGrade(markString, "4"));
        }
        for (int i = 0; i < TEST_CASES; i++) {
            double mark = fourCreditGrade.FLow + random.nextDouble();
            String markString = Double.toString(mark);
            assertEquals('F', GradeCalculator.calculateGrade(markString, "4"));
        }
    }

    @Test
    @DisplayName("Out of range number test")
    public void outOfRangeNumberTest(){
        for(int i=0;i<TEST_CASES;i++){
            double mark = -1 + random.nextDouble();
            String markString = Double.toString(mark);
            assertThrows(IllegalArgumentException.class, ()-> GradeCalculator.calculateGrade(markString, "3"));
            assertThrows(IllegalArgumentException.class, ()-> GradeCalculator.calculateGrade(markString, "4"));
        }
        for(int i=0;i<TEST_CASES;i++){
            double mark = 401 - random.nextDouble();
            String markString = Double.toString(mark);
            assertThrows(IllegalArgumentException.class, ()-> GradeCalculator.calculateGrade(markString, "3"));
            assertThrows(IllegalArgumentException.class, ()-> GradeCalculator.calculateGrade(markString, "4"));
        }
    }

    @Test
    @DisplayName("Non number test")
    public void nonNumberTest(){
        assertThrows(NullPointerException.class, ()->GradeCalculator.calculateGrade(null, "3"));
        assertThrows(NumberFormatException.class, ()->GradeCalculator.calculateGrade("1..2a", "3"));
        assertThrows(NullPointerException.class, ()->GradeCalculator.calculateGrade(null, "4"));
        assertThrows(NumberFormatException.class, ()->GradeCalculator.calculateGrade("0..1a", "4"));
    }

    @Test
    @DisplayName("Invalid Credit Test")
    public void invalidCreditTest(){
        assertThrows(IllegalArgumentException.class, ()->GradeCalculator.calculateGrade("250", "5"));
        assertThrows(IllegalArgumentException.class, ()->GradeCalculator.calculateGrade("250", "-1"));
        assertThrows(NumberFormatException.class, ()->GradeCalculator.calculateGrade("250", "abc"));
        assertThrows(NumberFormatException.class, ()->GradeCalculator.calculateGrade("250", null));
    }

    @Test
    @DisplayName("All null test")
    public void allNullTest(){
        assertThrows(NullPointerException.class, ()->GradeCalculator.calculateGrade(null, null));
    }
}