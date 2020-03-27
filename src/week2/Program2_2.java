package week2;

public class Program2_2 {
    public static void main(String[] args) {
        int sum = 1;
        System.out.println("1 부터 1까지의 합은 " + sum + " 입니다");

        sum = 1 + 2; // 1 -1
        System.out.println("1 부터 2까지의 합은 " + sum + " 입니다");

        sum = 1 + 2 + 3; // 2-1
        System.out.println("1 부터 3까지의 합은 " + sum + " 입니다");

        sum = 1 + 2 + 3 + 4; //3-1
        System.out.println("1 부터 4까지의 합은 " + sum + " 입니다");

        sum = 1 + 2 + 3 + 4 + 5; //4-1
        System.out.println("1 부터 5까지의 합은 " + sum + " 입니다");

        sum = 0; //0-1
        sum = sum + 1; //1-1
        System.out.println("1 부터 1까지의 합은 " + sum + " 입니다");

        sum = sum + 2; //1-1
        System.out.println("1 부터 2까지의 합은 " + sum + " 입니다");

        sum = sum + 3; // 1-1
        System.out.println("1 부터 3까지의 합은 " + sum + " 입니다");

        sum = sum + 4; //1-1
        System.out.println("1 부터 4까지의 합은 " + sum + " 입니다");

        sum = sum + 5; //1-1
        System.out.println("1 부터 5까지의 합은 " + sum + " 입니다");
    }
}

