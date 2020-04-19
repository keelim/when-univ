package week7;

import java.util.Scanner;

public class Program7_2 {
    static Scanner sc = new Scanner(System.in);
    static int acount = 0, bcount = 0, ccount = 0, dcount = 0, fcount = 0;

    public static void main(final String[] args) {
        int num;

        num = inputScore();
        while (num >= 0) {

            if (num > 100) {
                System.out.println("오류: 100이 넘어서, 정상적인 점수가 아닙니다.");
                num = inputScore();
                continue;
            }
            char grade = score2Grade(num);
            double point = score2Point(grade);
            System.out.println("점수: "+num+", 학점:"+grade+", 평점: "+point);

            num = inputScore();
        }
        System.out.println("음의 점수가 입력되어 입력을 종료합니다.\n");


        System.out.println("프로그램을 종료합니다.");

    }

    private static int inputScore() {
        System.out.print("");
        return sc.nextInt();
    }

    private static char score2Grade(int score) {
        if (score >= 90) {
            acount++;
            return 'A';
        }

        else if (score >= 80) {
            bcount++;
            return 'B';
        }

        else if (score >= 70) {
            ccount++;
            return 'C';
        }

        else if (score >= 60) {
            dcount++;
            return 'D';
        }

        else {
            fcount++;
            return 'F';
        }

    }

    private static double score2Point(char grade) {
        if (grade == 'A')
            return 4.0;
        else if (grade == 'B')
            return 3.0;
        else if (grade == 'C')
            return 2.0;
        else if (grade == 'C')
            return 1.0;
        else
            return 0.0;
    }

}