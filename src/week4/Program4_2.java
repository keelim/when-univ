package week4;

import java.util.Scanner;

public class Program4_2 {
    public static void main(String[] args) {
        int givenN, fact;
        char userAnswer;
        Scanner sc = new Scanner(System.in);

        System.out.println("<<Factorial 계산을 시작합니다. >>");
        System.out.print("\nFactorial 을 계산하려면 ‘Y’ 또는 ‘y’ 를, 아니면 다른 아무 키나 입력하시오: ");

        userAnswer = sc.next().charAt(0); // 사용자의 대답을 얻기 위해 키보드에서 글자 하나를 입력 받는다

        while ( /* 대답이 ‘Y’ 또는 'y' 이면 */ userAnswer == 'Y' || userAnswer == 'y') {
            System.out.print("Factorial을 계산할 N 값을 입력하시오: ");
            givenN = sc.nextInt();
            fact = 1; // 초기화가 필요하다. //factorial 임으로 1

            if (givenN < 0) { // 값 비교
                System.out.println(givenN + " 의 값은 음수이므로, Factorial 값을 계산할 수 없습니다.\n");

            } else {
                if (givenN == 0) {
                    fact = 1;

                } else {
                    for (int i = 1; i <= givenN; i++) {
                        fact *= i;
                    }

                }
                System.out.println(givenN + " Factorial 의 값은 " + fact + " 입니다.\n"); // 결과 출력

            }
            System.out.print("Factorial 을 계산하려면 ‘Y’ 또는 ‘y’ 를, 아니면 다른 아무 키나 입력하시오: ");
            userAnswer = sc.next().charAt(0); // 사용자의 대답을 얻기 위해 키보드에서 글자 하나를 입력 받는다
        }
        System.out.println("\n<< Factorial 계산을 종료합니다. >>");
    }
}