package week10;

import java.util.Scanner;

public class Program10_1 {
    static final Scanner sc = new Scanner(System.in);
    private static final int MAX_SIZE = 100;

    public static void main(final String[] args) {


        Student student = new Student();
        GPACounter counter = new GPACounter();

        System.out.println("\n > 세 과목 (국어, 영어 , 컴퓨터)의 점수를 입력하시오: ");
        int scoreKorean = inputScore();
        student.setScoreKorean(scoreKorean);
        int scoreEnglish = inputScore();
        student.setScoreEnglish(scoreEnglish);
        int scoreComputer = inputScore();
        student.setScoreComputer(scoreComputer);
        while (scoreKorean >= 0 || scoreEnglish >= 0 || scoreComputer >= 0) {

            if (scoreComputer > 100 || scoreEnglish > 100 || scoreKorean > 100) {
                System.out.println("오류: 100이 넘어서, 정상적인 점수가 아닙니다.");
                System.out.println("\n > 세 과목 (국어, 영어 , 컴퓨터)의 점수를 입력하시오: ");
                scoreKorean = inputScore();
                student.setScoreKorean(scoreKorean);
                scoreEnglish = inputScore();
                student.setScoreEnglish(scoreEnglish);
                scoreComputer = inputScore();
                student.setScoreComputer(scoreComputer);
                continue;
            }
            System.out.println("[국 어] 점수:"+scoreKorean+", 학점: "+student.gradeKorean());
            System.out.println("[영 어] 점수:"+scoreEnglish+", 학점: "+student.gradeEnglish());
            System.out.println("[컴퓨터] 점수:"+scoreComputer+", 학점: "+student.gradeComputer());

            counter.count(student.gpa());

            System.out.println("이 학생의 평균평점은 "+student.gpa()+"입니다.");
            System.out.println("> 세 과목 (국어, 영어 , 컴퓨터)의 점수를 입력하시오: ");
            scoreKorean = inputScore();
            student.setScoreComputer(scoreKorean);
            scoreEnglish = inputScore();
            student.setScoreComputer(scoreEnglish);
            scoreComputer = inputScore();
            student.setScoreComputer(scoreComputer);
        }
        System.out.println("음의 점수가 입력되어 입력을 종료합니다.\n");

        System.out.println("평균평점이 3.0 이상인 학생은"+counter.numberOfGPA3()+"명 입니다.");
        System.out.println("평균평점이 2.0 이상 3.0 미만인 인 학생은"+counter.numberOfGPA2()+"명 입니다.");
        System.out.println("평균평점이 1.0 이상 2.0 미만인 학생은"+counter.numberOfGPA1()+"명 입니다.");
        System.out.println("평균평점이 1.0 미만인 학생은"+counter.numberOfGPA0()+"명 입니다.");


        System.out.println("프로그램을 종료합니다.");
    }


    private static int inputScore() {
        System.out.print("-점수를 입력하시오: ");
        return sc.nextInt();
    }


}