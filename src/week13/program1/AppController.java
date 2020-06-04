package week13.program1;

import java.util.Scanner;

public class AppController {
    private static final int MAX_STUDENTS = 50;

    private AppView _appView;
    private Ban _ban;

    public AppController() {
        this._appView = new AppView();
        this._ban = new Ban(MAX_STUDENTS);
    }

    public void run() {
        this._appView.outputLine("<<< 성적 처리를 시작합니다 >>>");
        this.inputAndStoreStudentsInfo();
        this.showStudentsInfo();
        this._ban.calcAverageInfo();
        this.showAverageInfo();
        this._ban.countStudentsByGrade();
        this.showGradeInfo();

        System.out.println("<<< 프로그램을 종료합니다. >>>");
    }


    private void inputAndStoreStudentsInfo() {

        boolean moreStudentExist;
        Student currentStudent = null;
        String studentNo = null;
        int score;

        moreStudentExist = this.inputMoreStudentsExist();
        while (moreStudentExist && (!this._ban.isFull())) {
            studentNo = this.inputStudentNo();
            score = this.inputScore();
            if (score < 0 || score > 100) {
                this._appView.outputLine("오류: 정상 범위 (0~100)의 점수가 아닙니다.\n");
            } else {
                currentStudent = new Student();
                currentStudent.setStudentNo(studentNo);
                currentStudent.setScore(score);
                this._ban.addStudent(currentStudent);
            }
            moreStudentExist = this.inputMoreStudentsExist();
        }


    }

    private boolean inputMoreStudentsExist() {
        this._appView.output("? 학생 정보를 입력하려면 'Y'를, 입력을 종료하려면 다른 아무거나 치시오: ");
        char answer = this._appView.inputChar();
        return (answer == 'Y' || answer == 'y');
    }

    private String inputStudentNo() {
        System.out.print("-학번을 입력하시오: ");
        String studentNo = this._appView.inputString();
        return studentNo;
    }

    private int inputScore() {
        System.out.print("-점수를 입력하시오: ");
        int score = this._appView.inputInt();
        return score;
    }


    private void showStudentsInfo() {
        this._appView.outputLine("학생들의 성적 목록입니다.");

        Student student = null;
        for (int i = 0; i < this._ban.numberOfStudents(); i++) {
            student = this._ban.studentAtOrder(i);
            this._appView.outputLine(("학번: " + student.studentNo() + "점수: " + student.score() + "학점: " + student.grade()));
        }

    }

    private void showAverageInfo() {
        this._appView.outputLine("\n평균점수는 " + String.format("%.2f",_ban.average()) + " 입니다.\n");
    }

    private void showGradeInfo() {
        this._appView.outputLine("평균 이상인 학생의 성적은 다음과 같습니다.\n");
        Student student = null;
        for (int i = 0; i < _ban.numberOfStudents(); i++) {
            student = _ban.students()[i];
            if (student.score() > _ban.average())
                System.out.printf("학번: %s 점수: %d 학점: %c \n", student.studentNo(), student.score(), student.grade());
        }

        this._appView.outputLine("A 학점은 모두     " + this._ban.numberOfStudentsFoRGradeA() + " 명 입니다.");
        this._appView.outputLine("B 학점은 모두     " + this._ban.numberOfStudentsFoRGradeB() + " 명 입니다.");
        this._appView.outputLine("C 학점은 모두     " + this._ban.numberOfStudentsFoRGradeC() + " 명 입니다.");
        this._appView.outputLine("D 학점은 모두     " + this._ban.numberOfStudentsFoRGradeD() + " 명 입니다.");
        this._appView.outputLine("F 학점은 모두     " + this._ban.numberOfStudentsFoRGradeF() + " 명 입니다.");
    }
}
