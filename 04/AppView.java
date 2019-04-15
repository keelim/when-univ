import java.util.Scanner;

public class AppView {
    private static Scanner sc = new Scanner(System.in);

    private AppView() { //constructor

    }

    public static void outputDebugMessage(String message) { //디버그 메시지 출력
        outputLine(message);
    }

    public static void outputLine(String message) { //message 출력
        System.out.println(message);
    }

    public static void output(String message) { //message 출력
        System.out.print(message);
    }

    public static int inputInteger() throws NumberFormatException { //integer 입력
        return Integer.parseInt(AppView.sc.next());
    }
}
