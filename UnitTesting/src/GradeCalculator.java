import java.util.Random;

public class GradeCalculator {
    public static char calculateGrade(String obtainedMark, String subjectCredit) {
        double mark = Double.parseDouble(obtainedMark);
        int credit = Integer.parseInt(subjectCredit);
        if (mark < 0 || mark > 400) throw new IllegalArgumentException("Mark must be within [0, 400]");
        if (credit == 3) return threeCreditMark((int) Math.ceil(mark));
        else if (credit == 4) return fourCreditGrade((int) Math.ceil(mark));
        else throw new IllegalArgumentException("Credit must be either 3 or 4");
    }

    private static char threeCreditMark(int mark) {
        if (mark >= 240 && mark <= 400) return 'A';
        else if (mark >= 210 && mark <= 239) return 'B';
        else if (mark >= 180 && mark <= 209) return 'C';
        else return 'F';
    }

    private static char fourCreditGrade(int mark) {
        if (mark >= 320 && mark <= 400) return 'A';
        else if (mark >= 280 && mark <= 319) return 'B';
        else if (mark >= 240 && mark <= 279) return 'C';
        else return 'F';
    }

    public static void main(String[] args) {
        Random random=new Random();
    }
}
