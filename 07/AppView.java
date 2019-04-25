import java.util.Scanner;

public class AppView {
    private static Scanner sc = new Scanner(System.in);

    public static void output(String aMessage) {
        System.out.print(aMessage);
    }

    public static void outputLine(String aMessage) {
        System.out.println(aMessage);
    }

    public static char inputChar() {
        String line = AppView.sc.nextLine().trim(); //문자 앞뒤 공백 문자를 제거해 준다.

        while (line.equals("")) { //입력된 문자열이 비어있다. ?
            line = AppView.sc.nextLine().trim();
        }

        return line.charAt(0);
    }
}
