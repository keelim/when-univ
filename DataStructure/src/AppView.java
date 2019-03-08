import java.util.Scanner; //완료

public class AppView {
    private static Scanner scanner = new Scanner(System.in); //변수를 static 으로 선언을 해야하지만 사용이 가능

    public static void outputLine(String s) {

        System.out.println(s);
    }

    public static int inputOrder() {
        System.out.print("?마방진 차수를 입력하시오(음수를 입력하면 종료합니다. ):");
        return scanner.nextInt();
    }

    public static void outputTitleWithOrder(int currentOrder) {
        System.out.print("!Magic Square Board Order " + currentOrder);
        System.out.println();
    }

    public static void outputRowNumber(int number) {
        System.out.printf("[%3d]", number);
    }


    public static void outputCellValue(int value) {

        System.out.printf("  %3d", value);
    }

    public static void output(String format) {
        System.out.print(format);
    }
}
