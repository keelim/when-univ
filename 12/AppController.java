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
    } //gradeCounter getter

    public void setGradeCounter(GradeCounter newGradeCounter) { //gradecounter stteer
        this._gradeCounter = newGradeCounter;
    } //setter


    private static boolean scoreIsValid(int aScore) { //유효성 확인
        return (aScore >= AppController.VALID_MIN_SCORE && aScore <= AppController.VALID_MAX_SCORE);
    }

    private static Student inputStudent(String studentNumber) { //오류 메시지 출력 및 student 점수 입력
        int score = AppView.inputScore();  //점수 입력
        boolean flag = false;
        if(studentNumber.length()> 9){
            AppView.outputLine("(오류) 학번의 길이가 너무 깁니다. 최대 9입니다.");
            flag = true;
        }

        if (!AppController.scoreIsValid(score)) { //유효성 확인
            AppView.outputLine("[오류]" +
                    AppController.VALID_MIN_SCORE + "보다 작거나" +
                    AppController.VALID_MAX_SCORE + " 보다 커서 , 정상적인 점수가 아닙니다. ");
            flag = true;

        }
        if(flag){
            return null;
        } else {
            Student student = new Student();
            student.setScore(score); //점수 설정 후 리턴
            return student;
        }
    }

    private void inputAndStoreStudents() { //Ban 트리에 집어 넣는다.
        AppView.outputLine("");
        boolean storingAStudentWasSucessful = true;

        while (storingAStudentWasSucessful && AppView.doesContinueToInputStudent()) {
            String studentNumber = AppView.inputStudentNumber();
            Student student = inputStudent(studentNumber);
            if(student == null){
                continue;
            }

            if (!this.ban().addKeyAndObject(studentNumber, student)) { //학생을 ban에 넣는다.
                AppView.outputLine("(경고) 입력에 오류가 있습니다. 학급에 더이상 학생을 넣을 공간이 없습니다. "); //오류 메시지 출력
                storingAStudentWasSucessful = false;
            }
        }
        AppView.outputLine("<성적 입력을 마칩니다.>");
    }

    private void showStatistics() { //통계함수 출력
        AppView.outputLine("");
        AppView.outputLine("[학급 성적 처리 결과]");

        AppView.outputTotalNumberOfStudents(this.ban().size()); //학생수
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

    private void showStudentSortedByScore() { //학생들을 성적순 으로 출력을 한다.
        AppView.outputLine("");
        AppView.outputLine("[학생들의 성적 순 목록]");

        this.ban().studentSortedByScore(); //성적 순으로 정렬

        Iterator<DictionaryElement<String, Student>> iterator = this.ban().iterator(); //Iterator 를 사용을 하여 출력을 한다.
        while (iterator.hasNext()) { //iterator 반복
            DictionaryElement<String, Student> element = iterator.next();
            String studentNumber = element.key();
            int score = element.object().score();
            char grade = Ban.scoreToGrade(element.object().score());
            AppView.outputStudentInfo(studentNumber, score, grade);//학생 점수 출력
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
            this.showStudent();
            this.showStatistics(); //통계함수 출력
            this.showGradeCounts(); //학점 별 학생 수 출력
            this.showStudentSortedByScore(); //학생들의 성적 순 목록

        }
        AppView.outputLine("");
        AppView.outputLine("\n <<< 학급 성적 처리를 종료합니다. >>>");


    }

    private void showStudent() {
        AppView.outputLine("");
        AppView.outputLine("[학생 목록]");

        Iterator<DictionaryElement<String, Student>> iterator = this.ban().iterator(); //Iterator 를 사용을 하여 출력을 한다.
        while (iterator.hasNext()) { //iterator 반복
            DictionaryElement<String, Student> element = iterator.next();
            //Iterator를 통하여 받은 object 엘리먼트 값을 통하여
            //학번과 학생의 점수를 받는다.
            String studentNumber = element.key();
            int score = element.object().score();
            AppView.outputStudentlist(studentNumber, score);//학생 점수 출력
        }
    }

}