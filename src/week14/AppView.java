package week14;

import java.util.Scanner;

public class AppView {
    private static Scanner scanner = new Scanner(System.in); //변수를 static 으로 선언을 해야하지만 사용이 가능


    public int inputInt() {
        return scanner.nextInt();
    }

    public static void showRowNumber(int number) {
        System.out.printf("[%2d]", number);
    }


    public static void showCellValue(int value) {
        System.out.printf("%5d", value);
    }

    public void output(String aMessage) {
        System.out.print(aMessage);
    }

    public static void outputLine(String aMessage) {
        System.out.println(aMessage);
    }

    public void outputLine(String aMessage, int value) {
        System.out.printf(aMessage, value);
    }


}
