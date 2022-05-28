package week4;

import java.util.Scanner;

public class Program4_1 {
    public static void main(final String[] args) {
        double a, b, c, determinant, x1, x2;
        char userAnswer;
        Scanner sc = new Scanner(System.in); // 입력을 받을때는 Scanner 클래스를 이용한다.

        System.out.println("<< 이차방정식 풀이 프로그램을 시작합니다.>>\n");
        System.out.print("> 이차방정식 풀이를 하겠습니까? 하려면 'Y' 또는 'y' 를 입력하시오: ");
        userAnswer = sc.next().charAt(0); // 사용자의 대답을 얻기 위해 키보드에서 글자 하나를 입력 받는다
        while ( /* 대답이 ‘Y’ 또는 'y' 이면 */ userAnswer == 'Y' || userAnswer == 'y') {

            System.out.print("-2 차항의 계수 (a)를 입력하시오: ");
            a = sc.nextDouble();

            System.out.print("-1 차항의 계수 (b)를 입력하시오: ");
            b = sc.nextDouble();

            System.out.print("- 상수항의 계수 (c)를 입력하시오: ");
            c = sc.nextDouble();

            System.out.println("입력된 방정식의 계수: a=" + a + " b=" + b + " c=" + c); // a, b, c입력
            determinant = b * b - 4.0 * a * c;

            if ((-0.0000001 < a) && (a < 0.0000001)) { // double 이기에 범위를 통하여 0 인지를 인식
                System.out.println("오류: 2차항의 계수가 0이므로, 이차방정식을 풀 수 없습니다.");

            } else if (determinant > 0) {
                x1 = ((-b + Math.sqrt(determinant)) / (2.0 * a));
                x2 = ((-b - Math.sqrt(determinant)) / (2.0 * a));
                System.out.format("방정식의 해: %.1f 또는 %.1f\n", x1, x2);

            } else if (determinant == 0) {
                x1 = ((-b + Math.sqrt(determinant)) / (2.0 * a));
                System.out.println("방정식의 해: " + x1);

            } else {
                System.out.println("[오류] 판별식의 값이 음수이어서 이차방정식의 해가 존재하지 않습니다.");
            }

            System.out.print("\n> 이차방정식 풀이를 하겠습니까? 하려면 'Y' 또는 'y' 를 입력하시오: ");
            userAnswer = sc.next().charAt(0); // 사용자의 대답을 얻기 위해 키보드에서 글자 하나를 입력 받는다
        }

        System.out.println("\n<< 이차방정식 풀이 프로그램을 종료합니다 >>");
    }
}
