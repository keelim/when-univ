

import java.util.Scanner;

public class Program7_2 {
    static Scanner sc = new Scanner(System.in);
    static int count1 = 0, count2 = 0, count3 = 0, count4 = 0;

    public static void main(final String[] args) {
        int korean, english, computer;

        System.out.println(">세 과목 (국어, 영어, 컴퓨터) 의 점수를 차례로 입력합니다.");
        korean = inputScore();
        english = inputScore();
        computer = inputScore();

        while (korean >= 0 && english >= 0 && computer >= 0) {

            if (korean > 100 || english > 100 || computer > 100) {
                System.out.println("오류: 100이 넘어서, 정상적인 점수가 아닙니다.\n");
                System.out.println(">세 과목 (국어, 영어, 컴퓨터) 의 점수를 차례로 입력합니다.");
                korean = inputScore();
                english = inputScore();
                computer = inputScore();
                continue;
            }
            char grade1 = score2Grade(korean);
            char grade2 = score2Grade(english);
            char grade3 = score2Grade(computer);

            double point1 = score2Point(grade1);
            double point2 = score2Point(grade2);
            double point3 = score2Point(grade3);

            System.out.println("[국  어]점수: " + korean + ", 학점:" + grade1 + ", 평점: " + point1);
            System.out.println("[영  어]점수: " + english + ", 학점:" + grade2 + ", 평점: " + point2);
            System.out.println("[컴퓨터]점수: " + computer + ", 학점:" + grade3 + ", 평점: " + point3);

            double gpa = calcGPA(point1, point2, point3);
            System.out.format("이 학생의 평균평점은 %.2f 입니다.\n\n",gpa);

            countGPA_Person(gpa);

            System.out.println(">세 과목 (국어, 영어, 컴퓨터) 의 점수를 차례로 입력합니다.");
            korean = inputScore();
            english = inputScore();
            computer = inputScore();
        }
        System.out.println("음의 점수가 입력되어 입력을 종료합니다.\n");
        printCount();

        System.out.println("\n프로그램을 종료합니다.");

    }

    private static void printCount(){
        System.out.println("평균 평점 대 별 학생 수는 다음과 같습니다.");
        System.out.println("- 3.0 이상: " + count3 + " 명");
        System.out.println("- 2.0 이상 3.0 미만: " + count2 + " 명");
        System.out.println("- 1.0 이상 2.0 미만: " + count1 + " 명");
        System.out.println("- 1.0 미만: " + count4 + " 명");
    }

    private static int inputScore() {
        System.out.print("- 점수를 입력하시오: ");
        return sc.nextInt();
    }

    private static char score2Grade(int score) {
        if (score >= 90)
            return 'A';

        else if (score >= 80)
            return 'B';

        else if (score >= 70)
            return 'C';

        else if (score >= 60)
            return 'D';

        else
            return 'F';
    }

    private static double score2Point(char grade) {
        if (grade == 'A')
            return 4.0;
        else if (grade == 'B')
            return 3.0;
        else if (grade == 'C')
            return 2.0;
        else if (grade == 'D')
            return 1.0;
        else
            return 0.0;
    }

    private static double calcGPA(double score1, double score2, double score3) { //평균 학점 계산
        return (score1 + score2 + score3) / 3.0;
    }

    private static void countGPA_Person(double gpa) { // 학점 명 수 계산
        if (gpa >= 3.0)
            count3++;
        else if (gpa >= 2.0)
            count2++;
        else if (gpa >= 1.0)
            count1++;
        else
            count4++;
    }

}