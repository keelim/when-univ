import java.util.Scanner;

public class AppView {
    private static Scanner scanner = new Scanner(System.in);


    public static void outputLine(String message) { // System.out.println�� AppView�� ���Ͽ� ���
        System.out.println(message);

    }

    public static int inputMenuNumber() { //�޴� ��ȣ�� �Է��Ѵ�.
        System.out.print("?  �����Ϸ��� �ϴ� �޴� ��ȣ�� �����Ͻÿ� (add:1, remove:2, search:3, frequency:4, exit:9): ");
        int input_Number = scanner.nextInt();
        return input_Number;

    }

    public static int inputCapacityOfCoinBag() { //���� ������ ũ�⸦ �Է�
        int capacity = 0;
        System.out.print("?���� ������ ũ��, �� ���濡 �� ������ �ִ� ������ �Է��Ͻÿ�: ");
        capacity = scanner.nextInt();
        return capacity;
    }

    public static int inputCoinValue() { // ������ ���� �Է�
        int value = 0;
        System.out.print("? ������ ���� �Է��Ͻÿ�: ");
        value = scanner.nextInt();
        return value;
    }
}
