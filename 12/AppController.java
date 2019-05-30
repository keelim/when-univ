public class AppController {
    private static final int VALID_MAX_SCORE = 100;
    private static final int VALID_MIN_SCORE = 0;
    private static final int BAN_CAPACITY = 10;

    private Ban _ban;
    private GradeCounter _gradeCounter;

    public Ban ban() {
        return _ban;
    } //ban getter

    public void setBan(Ban newBan) {
        this._ban = newBan;
    } //ban setter

    public GradeCounter gradeCounter() {
        return _gradeCounter;
    } //gradecounter getter

    public void setGradeCounter(GradeCounter newGradeCounter) { //gradecounter stteer
        this._gradeCounter = newGradeCounter;
    }


    private static boolean scoreIsValid(int aScore) { //유효성 확인
        return (aScore >= AppController.VALID_MIN_SCORE && aScore <= AppController.VALID_MAX_SCORE);
    }

    private static Student inputStudent() { //오류 메시지 출력 및 student 점수 입력
        int score = AppView.inputScore();  //점수 입력
        while (!AppController.scoreIsValid(score)) { //유효성 확인
            AppView.outputLine("[오류]" +
                    AppController.VALID_MIN_SCORE + "보다 작거나" +
                    AppController.VALID_MAX_SCORE + "보다 커서 , 정상적인 점수가 아닙니다. ");
            score = AppView.inputScore(); //오류 시 다시 재입력
        }

        Student student = new Student();
        student.setScore(score); //점수 설정 후 리턴
        return student;

    }

    private void inputAndStoreStudents() { //학생을 Stack에 넣는다.
        AppView.outputLine("");
        boolean storingAStudentWasSucessful = true;

        while (storingAStudentWasSucessful && AppView.doesContinueToInputStudent()) {
            Student student = this.inputStudent();
            if (!this.ban().add(student)) { //학생을 ban에 넣는다.
                AppView.outputLine("(경고) 입력에 오류가 있습니다. 학급에 더이상 학생을 넣을 공간이 없습니다. "); //오류 메시지 출력
                storingAStudentWasSucessful = false;
            }
        }
        AppView.outputLine("! 성적 입력을 마칩니다. ");
    }

    private void showStatistics() { //통계함수 출력
        AppView.outputLine("");
        AppView.outputLine("[학급 성적 통계]");

        AppView.outputNumberOfStudents(this.ban().size()); //학생수
        AppView.outputHighestScore(this.ban().highest().score()); //최고점
        AppView.outputLowestScore(this.ban().lowest().score());  //최저점
        AppView.outputAverageScore(this.ban().average());       //평균 점수
        AppView.outputNumberOfStudentsAboveAverage(this.ban().numberOfStudentsAboveAverage()); //평균 점수 이상

    }

    private void showGradeCounts() { //학점 별 학생의 점수를 출력한다.
        AppView.outputLine("");
        AppView.outputLine("[학점 별 학생 수]");

        this.setGradeCounter(this.ban().countGrade()); //grade를 count 한다.
        AppView.outputNumberOfStudentsForGrade('A', this.gradeCounter().numberOfA()); //number a
        AppView.outputNumberOfStudentsForGrade('B', this.gradeCounter().numberOfB()); //number b
        AppView.outputNumberOfStudentsForGrade('C', this.gradeCounter().numberOfC()); //number c
        AppView.outputNumberOfStudentsForGrade('D', this.gradeCounter().numberOfD()); //number d
        AppView.outputNumberOfStudentsForGrade('F', this.gradeCounter().numberOfF()); //number f
    }

    private void showStudensSortedByScore() { //학생들을 성적순 으로 출력을 한다.
        AppView.outputLine("");
        AppView.outputLine("[학생들의 성적 순 목록]");

        this.ban().sortByScore(); //성적 순으로 정렬

        Iterator<Student> iterator = this.ban().iterator(); //Iterator 를 사용을 하여 출력을 한다.
        Student student = null;
        while (iterator.hasNext()) { //iterator 반복
            student = iterator.next();
            AppView.outputScore(student.score()); //학생 점수 출력
        }
    }


    public void run() { //실행
        AppView.outputLine("");
        AppView.outputLine("<<< 학급 성적 처리를 시작합니다. >>>");

        this.setBan(new Ban()); //ban을 생성
        this.inputAndStoreStudents(); //학생들의 점수 입력

        if (this.ban().isEmpty()) {  // 비어있는지 확인
            AppView.outputLine("");
            AppView.outputLine("(경고) 입력된 성적이 없습니다. ");

        } else {
            this.showStatistics(); //통계함수 출력
            this.showGradeCounts(); //학점 별 학생 수 출력
            this.showStudensSortedByScore(); //학생들의 성적 순 목록

        }
        AppView.outputLine("");
        AppView.outputLine("<<< 학급 성적 처리를 종료합니다. >>>");


    }



    private void showStudentsSortedByScore() { //TODO
        AppView.outputLine("");
        AppView.outputLine("학생들의 성적순 목록");
        Student[] students = this.ban().studentSortedByScore();
        for (int i = 0; i < this.ban().size(); i++) {
            AppView.outputStudentInfo(students[i].id(), students[i].score(), Ban.scoreToGrade(students[i].score()));
        }
    }
}