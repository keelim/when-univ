package week12;

import java.util.Scanner;

public class AppController {
    private static final int MAX_STUDENTS = 50;
    private Scanner sc;
    private Ban _ban;

    public AppController() {
        this.sc = new Scanner(System.in);
        this._ban = new Ban(MAX_STUDENTS);
    }

    public void run() {
        this.inputAndStoreStudentsInfo();
        this.showStudentsInfo();
        this._ban.calcAverageInfo();
        this._ban.countStudentsByGrade();
        this.showGradeInfo();
        this.showAverageInfo();

        System.out.println("프로그램을 종료합니다.");
    }


    private void inputAndStoreStudentsInfo() {
        boolean moreStudentExist;
        Student currentStudent = null;
        int score;
        String studentNo = null;

        moreStudentExist = inputMoreStudentsExist();
        while (moreStudentExist && (!_ban.isFull())) {
            studentNo = inputStudentNo();
            score = inputScore();
            if (score < 0 || score > 100) {
                System.out.println("오류: 0보다 작서나 100 보다 커서, 정상적인 점수가 아닙니다.\n");
            } else {
                currentStudent = new Student();
                currentStudent.setStudentNo(studentNo);
                currentStudent.setScore(score);
                _ban.addStudent(currentStudent);
            }
            System.out.println();
            moreStudentExist = inputMoreStudentsExist();
        }

    }

    private String inputStudentNo() {
        System.out.print("-학번을 입력하시오: ");
        return sc.next();
    }

    private int inputScore() {
        System.out.print("-점수를 입력하시오: ");
        return sc.nextInt();
    }


    private boolean inputMoreStudentsExist() {
        System.out.print("? 학생정보를 입력하려면 'Y'를 입력을 종료하려면 'N' 을 치시오: ");
        String temp = sc.next();
        if (temp.equals("Y") || temp.equals("y")) {
            return true;
        } else {
            System.out.println("입력을 종료합니다. \n");
            return false;
        }
    }

    private void showStudentsInfo() {
        System.out.println("\n 학생들의 성적 목록입니다.");

        for (int i = 0; i < _ban.numberOfStudents(); i++) {
            Student tempStu = _ban.students()[i];
            System.out.printf("학번: %s 점수: %d 학점: %c \n", tempStu.studentNo(), tempStu.score(), tempStu.grade());

        }

    }

    private void showAverageInfo() {
        System.out.println("A 학점은 모두 " + _ban.numberOfStudentsFoRGradeA() + " 명 입니다.");
        System.out.println("B 학점은 모두 " + _ban.numberOfStudentsFoRGradeB() + " 명 입니다.");
        System.out.println("C 학점은 모두 " + _ban.numberOfStudentsFoRGradeC() + " 명 입니다.");
        System.out.println("D 학점은 모두 " + _ban.numberOfStudentsFoRGradeD() + " 명 입니다.");
        System.out.println("F 학점은 모두 " + _ban.numberOfStudentsFoRGradeF() + " 명 입니다.");
    }

    private void showGradeInfo() {

        System.out.printf("\n 평균점수는 %.2f 입니다.", _ban.average());
        System.out.println("평균 이상인 학생은 모두 " + _ban.numberOfStudentsWithAboveAverage() + " 입니다.");
        Student student = null;
        for (int i = 0; i < _ban.numberOfStudents(); i++) {
            student = _ban.students()[i];
            if (student.score() > _ban.average())
                System.out.printf("학번: %s 점수: %d 학점: %c \n", student.studentNo(), student.score(), student.grade());
        }
        System.out.println();


    }
}
