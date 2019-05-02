import java.util.Scanner;

public class AppView {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean debugMode = false;

    public AppView() {

    }

    public static boolean debugMode() { //getter
        return debugMode;
    }

    public static void setDebugMode(boolean debugMode) { //setter
        AppView.debugMode = debugMode;
    }

    public static void outputDebugMessage(String aMessage) {
        if (AppView.debugMode()) {
            System.out.print(aMessage);
        }
    }

    public static void outputLineDebugMessage(String aMessage) {
        System.out.println(aMessage);
    }

    public static void output(String aMessage) {
        System.out.print(aMessage);
    }

    public static void outputLine(String aMessage) {
        System.out.println(aMessage);
    }

    public static String inputLine() {
        String line = AppView.scanner.nextLine().trim(); //입력을 받는다.
        while (line.equals("")) { //빈줄일 경우 다시 입력을 받는다.
            line = AppView.scanner.nextLine().trim();
        }
        return line;
    }


}
