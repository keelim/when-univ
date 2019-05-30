public class AppController {
    public void run() {
    }


    private void showStudentsSortedByScore() { //TODO
        AppView.outputLine("");
        AppView.outputLine("학생들의 성적순 목록");
        Student[] students = this.ban().studentsSortedByScore();
        for (int i = 0; i < this.ban().size(); i++) {
            AppView.outputStudentInfo(students[i].id(), students[i].score(), Ban.scoreToGrade(students[i].score()));
        }
    }
}