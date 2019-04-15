import java.util.Scanner;

public class AppView {
    private static Scanner scanner = new Scanner(System.in);

    public static void outputLine(String aMessage) {
        System.out.println(aMessage);
    }

    public static void output(String aMessage) {
        System.out.print(aMessage);
    }

    public static void outpuResults(int size, long durationForAdd, long durationForMax) {
        AppView.outputLine(
                "[Å©±â: " + String.format("%5d", size) + "] " +
                        "»ðÀÔ: " + String.format("%8d", durationForAdd) + "] " +
                        "ÃÖ´ñ°ª: " + String.format("%8d", durationForMax) + "] "
        );
    }


}
