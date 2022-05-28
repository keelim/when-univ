package week6;

import java.util.Scanner;

public class Program6_1 {
    static Scanner sc = new Scanner(System.in);

    public static void main(final String[] args) {
        int num = 0;
        System.out.println("<< 양의 정수 값을 별의 개수로 출력하는 프로그램을 시작합니다. >>\n");
    
        num = inputNumber();
        while (num > 0) { // while loop 를 이용해서 양의 정수 아니면 종료
            printAsterisks(num);
            num = inputNumber();
        }

        System.out.println("<<양의 정수 값을 별의 개수로 출려하는 프로그램을 종료합니다. >>");
    }

    private static void printAsterisks(int n) {
        for (int i = 0; i < n; i++) { //반복문 이용해서 별표를 찍는다
            System.out.print("*");
        }
        System.out.println("");
    }

    private static int inputNumber() {
        int temp;
        System.out.println("양의 정수 (종료하려면 음수)를 입력하시오: ");
        temp = sc.nextInt();
        return temp;
    }
}