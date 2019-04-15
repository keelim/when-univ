import java.util.Scanner;

public class AppView {
    private static Scanner scanner = new Scanner(System.in);

    public static void outputLine(String aMessage) { //aMessage 출력
        System.out.println(aMessage);
    }

    public static void output(String aMessage) { //aMesseage 출력
        System.out.print(aMessage);
    }

    public static void outpuResults(int size, long durationForAdd, long durationForMax) { //formating 한 결과 출력
        AppView.outputLine(
                "[크기: " + String.format("%5d", size) + "] " +
                        "삽입: " + String.format("%8d", durationForAdd) + "] " +
                        "최댓값: " + String.format("%8d", durationForMax) + "] "
        );
    }


}
