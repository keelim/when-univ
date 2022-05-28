package week6;

public class Program6_2 {

    public static void main(final String[] args) {
        for (int i = 1; i <= 176; i += 5) {
            System.out.print("sine(");
            System.out.printf("%3d", i);
            System.out.println("도): ");

            double radian = ((double) i / 180.0) * Math.PI;
            double sineValue = Math.sin(radian); // Math.sin 사용

            // printAsterisks(sineValue);
            printAsterisksMyVersion(radian); //mySine() 사용
        }

    }

    private static void printAsterisks(double n) {

        int numberOfAsterisks = (int) ((n * 40.0) + 0.5);
        for (int i = 0; i < numberOfAsterisks; i++) {
            System.out.print("*");
        }
        System.out.println("");
    }

    private static void printAsterisksMyVersion(double n) {

        double sineValue = mySine(n); // my sin 사용
        int numberOfAsterisks = (int) ((sineValue * 40.0) + 0.5);
        for (int i = 0; i < numberOfAsterisks; i++) {
            System.out.print("*");
        }
        System.out.println("");
    }

    private static double mySine(double x) { // 53//54

        double xSquare = x * x;
        double currentTerm = x;
        int n = 2;
        double sineValue = currentTerm;
        while (Math.abs(currentTerm) >= 0.000001) {
            currentTerm = -currentTerm * xSquare / (double) (n * (n + 1));
            sineValue = sineValue + currentTerm;
            n = n + 2;
        }
        return sineValue;

    }

}