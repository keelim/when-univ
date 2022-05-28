package week11;

import java.util.Scanner;


public class Program11_1 {
    static final Scanner sc = new Scanner(System.in);
    private static final int MAX_STUDENTS = 50;
    private static week11.Student[] c1;
    private static int numberOfStudents = 0;
    private static double average;
    private static double upAverage = 0.0;
    private static int numberOfGradeA = 0;
    private static int numberOfGradeB = 0;
    private static int numberOfGradeC = 0;
    private static int numberOfGradeD = 0;
    private static int numberOfGradeF = 0;


    public static void main(final String[] args) {
        c1 = new week11.Student[MAX_STUDENTS];
        inputAndStoreStudentInfo();
        showStudentInfo();
        calcAverage();
        showAverageInfo();
        countStudentByGrade();
        showGradeInfo();
        System.out.println("프로그램을 종료합니다.");
    }

    private static void showGradeInfo() {
        System.out.println("A 학점은 모두 " + numberOfGradeA + " 명 입니다.");
        System.out.println("B 학점은 모두 " + numberOfGradeB + " 명 입니다.");
        System.out.println("C 학점은 모두 " + numberOfGradeC + " 명 입니다.");
        System.out.println("D 학점은 모두 " + numberOfGradeD + " 명 입니다.");
        System.out.println("F 학점은 모두 " + numberOfGradeF + " 명 입니다.");
    }

    private static void showAverageInfo() {
        System.out.println("평균점수는 " + average + " 입니다.");
        System.out.println("평균 이상인 학생은 모두 " + upAverage + " 입니다.");
    }

    private static void calcAverage() {
        int sum = 0;
        for (int i = 0; i < numberOfStudents; i++) {
            week11.Student student = new week11.Student();
            sum += student.score();
        }
        average = (double) sum / numberOfStudents;

        for (int i = 0; i < numberOfStudents; i++) {
            week11.Student student = new week11.Student();
            if (student.score() > average) upAverage++;
        }
    }

    private static void showStudentInfo() {
        System.out.println("\n 학생들의 성적 목록입니다.");

        for (int i = 0; i < numberOfStudents; i++) {
            week11.Student tempStu = c1[i];
            System.out.printf("학번: %s 점수: %d 학점: %c \n", tempStu.studentNo(), tempStu.score(), tempStu.grade());

        }
    }

    private static void countStudentByGrade() {
        for (int i = 0; i < numberOfStudents; i++) {
            char currentGrade = c1[i].grade();
            if (currentGrade == 'A') numberOfGradeA++;
            else if (currentGrade == 'B') numberOfGradeB++;
            else if (currentGrade == 'C') numberOfGradeC++;
            else if (currentGrade == 'D') numberOfGradeD++;
            else numberOfGradeF++;

        }
    }

    private static void inputAndStoreStudentInfo() {
        boolean moreStudentExist = inputMoreStudentsExist();
        while (moreStudentExist && numberOfStudents < MAX_STUDENTS) {
            String studentNo = inputStudentNo();
            int score = inputScore();

            if (score < 0 || score > 100)
                System.out.println("[오류 ] 잘못된 점수 입력");
            else {
                week11.Student currentStudent = new week11.Student();
                currentStudent.setStudentNo(studentNo);
                currentStudent.setScore(score);
                addStudent(currentStudent);
            }
            moreStudentExist = inputMoreStudentsExist();
        }
    }

    private static void addStudent(week11.Student aStudent) {
        c1[numberOfStudents] = aStudent;
        numberOfStudents++;
    }

    private static boolean inputMoreStudentsExist() {
        String temp = sc.next();
        if (temp.equals("Y") || temp.equals("y")) {
            return true;
        } else {
            System.out.println("입력을 종료합니다. \n");
            return false;
        }
    }

    private static String inputStudentNo() {
        return sc.next();
    }

    private static int inputScore() {
        System.out.print("-점수를 입력하시오: ");
        return sc.nextInt();
    }


}