import java.util.Scanner;

public class AppView {
    private static Scanner sc = new Scanner(System.in);

    private AppView() { //constructor

    }

    public static void outputDebugMessage(String message) { //����� �޽��� ���
        outputLine(message);
    }

    public static void outputLine(String message) { //message ���
        System.out.println(message);
    }

    public static void output(String message) { //message ���
        System.out.print(message);
    }

    public static int inputInteger() throws NumberFormatException { //integer �Է�
        return Integer.parseInt(AppView.sc.next());
    }
}
