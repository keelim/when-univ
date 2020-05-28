package week13.program2;

public class AppController {
    private static final int MAX_STUDENTS = 50;
    private AppView _appView;
    private Ban _ban;

    public AppController() {
        this._appView = new AppView();
        this._ban = new Ban(MAX_STUDENTS);
    }

    public void run() {
        this._appView.outputLine("<<<  성적 처리를 시작합니다. >>>");
        this.inputAndStudentsInfo();
        if (this._ban.isEmpty()) {
            this._appView.outputLine("[알림] 입력된 학생 정보가 없습니다.");
        } else {
            this.showStudentsInfo();
            this.showAverageInfo();
        }
        this._appView.outputLine("<<< 성적 처리를 종료합니다. >>>");
    }


    private void inputAndStudentsInfo() {
        boolean moreStudentExist;
        Student currentStudent = null;
        String studentNo = null;
        int korean, english, computer;

        moreStudentExist = this.inputMoreStudentsExist();
        while (moreStudentExist && (!this._ban.isFull())) {
            studentNo = this.inputStudentNo();
            korean = this.inputScore("국어");
            english = this.inputScore("영어");
            computer = this.inputScore("컴퓨터");


            currentStudent = new Student();
            currentStudent.setStudentNo(studentNo);

            Subject subject_korean = new Subject();
            subject_korean.setScore(korean);

            Subject subject_english = new Subject();
            subject_english.setScore(english);

            Subject subject_computer = new Subject();
            subject_computer.setScore(computer);


            currentStudent.setKorean(subject_korean);
            currentStudent.setEnglish(subject_english);
            currentStudent.setComputer(subject_computer);
            this._ban.addStudent(currentStudent);


            moreStudentExist = this.inputMoreStudentsExist();
        }
    }

    private String inputStudentNo() {
        this._appView.output("- 학번을 입력하시오: ");
        String studentNo = this._appView.inputString();
        return studentNo;
    }


    private boolean inputMoreStudentsExist() {
        this._appView.output("\n? 학생정보를 입력하려면 'Y'를, 입력을 종료하려면 다른 아무거나 치시오: ");
        char answer = this._appView.inputChar();
        return (answer == 'Y' || answer == 'y');
    }

    private void showStudentsInfo() {
        this._appView.outputLine("\n학생 수는 모두 " + this._ban.numberOfStudents() + "명 입니다.\n");

        this._appView.outputLine("학생들의 성적 목록입니다.");

        Student student = null;
        for (int i = 0; i < this._ban.numberOfStudents(); i++) {
            student = this._ban.studentAtOrder(i);
            this._appView.outputLine("학번: " + student.studentNo() +
                    " 국어: " + student.korean().score() + "(" + student.korean().grade() + ") " +
                    " 영어: " + student.english().score() + "(" + student.english().grade() + ") " +
                    " 컴퓨터: " + student.computer().score() + "(" + student.computer().grade() + ") " +
                    "평균평점은: " + String.format("%.2f", student.GPA()));

        }
        this._appView.outputLine("");

    }

    private void showAverageInfo() {
        this._ban.calcAverageInfo();
        this._appView.output("\n학급의 평균 평점은 " + String.format("%.2f", this._ban.average()) + "입니다.");
        this._appView.output("\n평균 평점 이상인 학생 수는 " + this._ban.numberOfStudentsWithAboveAverage() + " 입니다.\n\n");
    }


    private int inputScore(String subjectName) {
        int score;
        this._appView.output(subjectName + "점수를 입력하시오: ");
        score = this._appView.inputInt();

        while (score < 0 || score > 100) {
            this._appView.outputLine("[오류] 정상 범위 (0~100) 의 점수가 아닙니다.");

            this._appView.output(subjectName + "점수를 다시 입력하시오: ");
            score = this._appView.inputInt();
        }

        return score;
    }
}
