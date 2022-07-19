package util;

public class GradeFactory {
    private GradeFactory() {
    }

    public static Grade getGrades(int credit) {
        if (credit == 3) return new ThreeCreditGrade();
        else if (credit == 4) return new FourCreditGrade();
        else throw new IllegalArgumentException("Invalid credit");
    }
}
