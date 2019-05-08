import java.util.Scanner;

public class AppView {
    private static Scanner scanner = new Scanner(System.in); //Scanner

    public static void output(String aMessage) { //AppView.print
        System.out.print(aMessage);
    } //문자열 출력

    public static void outputLine(String aMessage) { //AppView.println
        System.out.println(aMessage);
    } //문자열 출력

    public static char inputChar() {
        String line = AppView.scanner.nextLine().trim(); //문자 앞뒤 공백 문자를 제거

        while (line.equals("")) { //입력된 문자열
            line = AppView.scanner.nextLine().trim();
        }

        return line.charAt(0);
    }
}
