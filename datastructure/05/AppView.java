import java.util.Scanner;

public class AppView {
    private static Scanner scanner = new Scanner(System.in);

    public static void outputLine(String aMessage) { //aMessage ���
        System.out.println(aMessage);
    }

    public static void output(String aMessage) { //aMesseage ���
        System.out.print(aMessage);
    }

    public static void outpuResults(int size, long durationForAdd, long durationForMax) { //formating �� ��� ���
        AppView.outputLine(
                "[ũ��: " + String.format("%5d", size) + "] " +
                        "����: " + String.format("%8d", durationForAdd) + "] " +
                        "�ִ�: " + String.format("%8d", durationForMax) + "] "
        );
    }


}
