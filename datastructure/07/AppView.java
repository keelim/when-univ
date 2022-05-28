import java.util.Scanner;

public class AppView {
    private static Scanner scanner = new Scanner(System.in); //Scanner

    public static void output(String aMessage) { //AppView.print
        System.out.print(aMessage);
    } //���ڿ� ���

    public static void outputLine(String aMessage) { //AppView.println
        System.out.println(aMessage);
    } //���ڿ� ���

    public static char inputChar() {
        String line = AppView.scanner.nextLine().trim(); //���� �յ� ���� ���ڸ� ����

        while (line.equals("")) { //�Էµ� ���ڿ�
            line = AppView.scanner.nextLine().trim();
        }

        return line.charAt(0);
    }
}
