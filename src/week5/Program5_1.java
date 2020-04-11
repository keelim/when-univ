package week5;

import java.util.Scanner;

public class Program5_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score, numberOfStudents, sumOfScores;
        double average;
        char grade = '\n'; 
        int acount = 0, bcount = 0, count = 0, dcount = 0, fcount = 0;
        numberOfStudents = 0;
        sumOfScores = 0; //변수 초기화

        System.out.println("<< 성적 처리 프로그램을 시작합니다. >>\n");
        System.out.print("성적을 입력하시오: "); //성적 입력
        score = sc.nextInt();
        
        while (score >= 0) {
            if (score > 100) { // 성적이 100 이 넘은 경우:
                System.out.println("오류: 100 이 넘는 성적이 입력되었습니다.\n");

            } else { // 성적이 100 이하로 정상인 경우:
                numberOfStudents++;
                sumOfScores += score;
                if (score >= 90 && score <= 100) { // 각각의 count 수를 늘려준다.
                    grade = 'A';
                    acount++;
                } else if (score >= 80 && score <= 89) {
                    grade = 'B';
                    bcount++;
                } else if (score >= 70 && score <= 79) {
                    grade = 'C';
                    count++;
                } else if (score >= 60 && score <= 69) {
                    grade = 'D';
                    dcount++;
                } else {
                    grade = 'F';
                    fcount++;
                }
                System.out.println("(성적: " + score + ", 학점: " + grade + ")");
            }
            System.out.print("성적을 입력하세요: ");
            score = sc.nextInt();
        }

        sc.close();

        average = (double) sumOfScores / (double) numberOfStudents; //평균을 캐스팅을 하여 넣어준다.

        System.out.println("\n학생수는 " + numberOfStudents + "입니다."); //각각의 변수들을 출력을 하고 종료를 한다.
        System.out.println("A는" + acount + " 명 입니다.");
        System.out.println("B는" + bcount + " 명 입니다.");
        System.out.println("C는" + count + " 명 입니다.");
        System.out.println("D는" + dcount + " 명 입니다.");
        System.out.println("F는" + fcount + " 명 입니다.");
        System.out.println("평균은 " + average + "입니다.");
        System.out.println("\n<< 성적 처리 프로그램을 종료합니다.>>");
    }

}
