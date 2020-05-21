package week13;

import java.util.Scanner;

public class AppController {
    private static final int MAX_STUDENTS = 50;
    private AppView _appView;
    private Scanner sc;
    private Ban _ban;

    public AppController() {
        this._appView = new AppView();
        this._ban = new Ban(MAX_STUDENTS);
    }

    public void run() {
        this._appView.outputLine("<<< 성적 처리를 시작합니다 >>>");
        this.inputStudentsInfo();
        this.showStudentsInfo();
        this._ban.calcAverageInfo();
        this.showAverageInfo();
        this._ban.countStudentsByGrade();
        this.showGradeInfo();

        this._appView.outputLine("<<< 성적 처리를 종료합니다. >>>");
    }


    private void inputStudentsInfo() {
        boolean moreStudentExist;
        Student currentStudent = null;
        String studentNo = null;
        int score;

        moreStudentExist = this.inputMoreStudentsExist();
        while (moreStudentExist && (!this._ban.isFull())) {
            studentNo = this.inputStudentNo();
            score = this.inputScore();
            if (score < 0 || score > 100) {
                this._appView.outputLine("[오류]");
            } else {
                currentStudent = new Student();
                currentStudent.setStudentNo(studentNo);
                currentStudent.setScore(score);
                this._ban.addStudent(currentStudent);
            }
            moreStudentExist = this.inputMoreStudentsExist();
        }
    }

    private String inputStudentNo() {
        this._appView.output("- 학번을 입력하시오: ");
        String studentNo = this._appView.inputString();
        return studentNo;
    }

    private int inputScore() {
        System.out.print("-점수를 입력하시오: ");
        int score = this._appView.inputInt();
        return score;
    }


    private boolean inputMoreStudentsExist() {
        this._appView.output("? 학생정보를 입력하려면 'Y'를, 입력을 종료하려면 다른 아무거나 치시오: ");
        char answer = this._appView.inputChar();
        return answer == 'Y';
    }

    private void showStudentsInfo() {
        this._appView.outputLine("학생들의 성적 목록입니다.");

        Student student = null;
        for(int i=0; i<this._ban.numberOfStudents();i++){
            student = this._ban.studentAtOrder(i);
            this._appView.outputLine("학번: "+student.studentNo()+"...");
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
        System.out.println("평균점수는 " + _ban.average() + " 입니다.");
        System.out.println("평균 이상인 학생은 모두 " + _ban.numberOfStudentsWithAboveAverage() + " 입니다.");


    }
}
