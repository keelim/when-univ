package week9;

import java.util.Scanner;

public class Program9_2 {
    static final Scanner sc = new Scanner(System.in);
    private static final int MAX_SIZE = 100;

    public static void main(final String[] args) {
        int[] num;
        int count = 0;
        int[] scoresKorean = new int[MAX_SIZE];
        int[] scoresComputer = new int[MAX_SIZE];
        double[] studentAverages = new double[MAX_SIZE];

        num = inputScore(); // korean computer
        if (num != null) {
            while ((num[0] >= 0 || num[1] >= 0)) {

                if (num[0] > 100 || num[1] > 100) {
                    System.out.println("오류: 100이 넘어서, 정상적인 점수가 아닙니다.");
                    num = inputScore();
                    continue;
                }
                scoresKorean[count] = num[0];
                scoresComputer[count] = num[1];
                count++;

                num = inputScore();
                if (num == null) break;
            }
        }

        System.out.println("음의 점수가 입력되어 입력을 종료합니다.\n");

        System.out.println("모두 " + count + " 명의 성적이 입력되었습니다.");

        for (int i = 0; i < count; i++) {
            studentAverages[i] = (double) (scoresKorean[i] + scoresComputer[i]) / 2;
        }

        double temp_average = 0;
        for (int i = 0; i < count; i++) {
            temp_average += studentAverages[i];
        }
        temp_average /= count;

        System.out.println("입력된 성적과 개인 평균은 다음과 같습니다.");
        int temp = 0;

        for (int i = 0; i < count; i++) {
            System.out.println(
                    "[" + i + "] " + scoresKorean[i] + " " + scoresComputer[i] 
                            + "(평균 " + studentAverages[i] + ")");
            if (studentAverages[i] >= temp_average)
                temp++;

        }

        System.out.println("\n 학급 평균은 " + temp_average + " 입니다.");
        System.out.println("\n평균 이상인 학생의 수는 " + temp + " 명 입니다.");

        System.out.println("\n프로그램을 종료합니다.");

    }

    private static int[] inputScore() {
        System.out.print("> 두 과목 (국어, 컴퓨터)의 점수를 차례로 입력하시오: ");
        int a, b;
        a = sc.nextInt();
        if (a < 0)
            return null;
        b = sc.nextInt();
        if (b < 0)
            return null;

        return new int[]{a, b};
    }
}