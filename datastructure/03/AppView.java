import java.util.Scanner;

public class AppView {
    private static Scanner scanner = new Scanner(System.in);


    public static void outputLine(String message) { // System.out.println을 AppView를 통하여 출력
        System.out.println(message);

    }

    public static int inputMenuNumber() { //메뉴 번호를 입력한다.
        System.out.print("?  수행하려고 하는 메뉴 번호를 선택하시오 (add:1, remove:2, search:3, frequency:4, exit:9): ");
        int input_Number = scanner.nextInt();
        return input_Number;

    }

    public static int inputCapacityOfCoinBag() { //동전 가방의 크기를 입력
        int capacity = 0;
        System.out.print("?동전 가방의 크기, 즉 가방에 들어갈 동전의 최대 개수를 입력하시오: ");
        capacity = scanner.nextInt();
        return capacity;
    }

    public static int inputCoinValue() { // 동전의 값을 입력
        int value = 0;
        System.out.print("? 동전의 값을 입력하시오: ");
        value = scanner.nextInt();
        return value;
    }
}
