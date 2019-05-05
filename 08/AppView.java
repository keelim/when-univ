import java.util.Scanner;

public class AppView {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean debugMode = false;

    public static boolean debugMode() { //getter
        return debugMode;
    }

    public static void setDebugMode(boolean debugMode) { //setter
        AppView.debugMode = debugMode;
    }

    public static void outputDebugMessage(String aMessage) { //메시지 출력
        if (AppView.debugMode()) {
            System.out.print(aMessage);
        }
    }

    public static void outputLineDebugMessage(String aMessage) { //메시지 출력
        System.out.println(aMessage);
    }

    public static void output(String aMessage) { //메시지 출력
        System.out.print(aMessage);
    }

    public static void outputLine(String aMessage) {
        System.out.println(aMessage);
    } //메시지 라인 출력

    public static String inputLine() { //입력을 받는다.
        String line = AppView.scanner.nextLine().trim(); //입력을 받는다.
        while (line.equals("")) { //빈줄일 경우 다시 입력을 받는다.
            line = AppView.scanner.nextLine().trim();
        }
        return line;
    }


}
