package week2;

public class Program2_3 {
    public static void main(String[] args) {
        int sum = 1;
        System.out.println("1 부터 1까지의 제곱의 합은 " + sum + " 입니다");
        sum = sum + 2 * 2;
        System.out.println("1 부터 2까지의 제곱의 합은 " + sum + " 입니다");
        sum = sum + 3 * 3;
        System.out.println("1 부터 3까지의 제곱의 합은 " + sum + " 입니다");
        sum = sum + 4 * 4;
        System.out.println("1 부터 4까지의 제곱의 합은 " + sum + " 입니다");
        sum = sum + 5 * 5;
        System.out.println("1 부터 5까지의 제곱의 합은 " + sum + " 입니다");
        sum = sum + 6 * 6;
        System.out.println("1 부터 6까지의 제곱의 합은 " + sum + " 입니다");
        sum = sum + 7 * 7;
        System.out.println("1 부터 7까지의 제곱의 합은 " + sum + " 입니다");
        sum = sum + 8 * 8;
        System.out.println("1 부터 8까지의 제곱의 합은 " + sum + " 입니다");
        sum = sum + 9 * 9;
        System.out.println("1 부터 9까지의 제곱의 합은 " + sum + " 입니다");
        sum = sum + 10 * 10;
        System.out.println("1 부터 10까지의 제곱의 합은 " + sum + " 입니다");

        sum = 1;
        System.out.println("1부터 1까지의 제곱의 합은" + sum + "");
        for (int i = 2; i <= 10; i++) {
            sum += i * i;
            System.out.println("1 부터 " + i + "까지의 제곱의 합은 " + sum + " 입니다.");
        }
    }
}

