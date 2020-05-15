package week8;

import java.util.Scanner;

public class Program8_1 {
    static final Scanner sc = new Scanner(System.in);
    private static final int MAX_SIZE = 100;

    public static void main(final String[] args) {
        int num;
        int count = 0;
        double average = 0;
        int[] scores = new int[MAX_SIZE];

        num = inputScore();
        while (num >= 0) {

            if (num > 100) {
                System.out.println("오류: 100이 넘어서, 정상적인 점수가 아닙니다.");
                num = inputScore();
                continue;
            }
            scores[count] = num;
            count++;

            num = inputScore();
        }
        System.out.println("음의 점수가 입력되어 입력을 종료합니다.\n");

        System.out.println("모두 " + count + " 명의 성적이 입력되었습니다.");

        for (int i = 0; i < count; i++) {
            average += scores[i];
        }
        average /= count;
        System.out.println("평균은 " + average + " 입니다.\n");
        int temp = 0;
        System.out.println("입력된 성적은 다음과 같습니다.");
        for (int i = 0; i < count; i++) {
            if (scores[i] >= average) {
                System.out.println("[" + i + "] " + scores[i] + " (평균 이상입니다.)");
                temp++;
            }

            else
                System.out.println("[" + i + "] " + scores[i] + " (평균 미만입니다.)");
        }

        System.out.println("\n평균 이상인 학생의 수는 " + temp + " 명 입니다.");

        System.out.println("\n프로그램을 종료합니다.");

    }

    private static int inputScore() {
        System.out.print("-점수를 입력하시오: ");
        return sc.nextInt();
    }
}