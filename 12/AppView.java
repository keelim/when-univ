import java.util.Scanner;

public class AppView {
    private static Scanner sc = new Scanner(System.in);

    public static void output(String aString) {
        System.out.print(aString);
    }

    public static void outputLine(String aString) {
        System.out.println(aString);
    }

    public static void outputTotalNumberOfStudents(int numberOfStudents) {
        System.out.println("학급 학생 수: " + numberOfStudents);
    }

    public static void outputHighestScore(int aScore) {
        System.out.println("학급 최고 점수 : " + aScore);
    }

    public static void outputLowestScore(int aScore) {
        System.out.println("학급 최저 점수: " + aScore);
    }

    public static void outputAverageScore(double average) {
        System.out.println("학급 평균: " + average);
    }

    public static void outputNumberOfStudentsAboveAverage(int numberOfStudents) {
        System.out.println("평균 이상인 학생 수 : " + numberOfStudents);
    }

    public static void outputNumberOfStudentsForGrade(char aGrade, int numberOfStudents) {
        System.out.println(aGrade + " 이상인 학생 수 : " + numberOfStudents);
    }

    public static void outputStudentInfo(String aStudentID, int aScore, char aGrade) {
        AppView.outputLine("학번:" + aStudentID + " 점수: " + aScore + "학점: " + aGrade);
    }
    public static void outputStudentlist(String aStudentID, int aScore) {
        AppView.outputLine("학번:" + aStudentID + " 점수: " + aScore);
    }

    public static int inputInt() throws NumberFormatException {
        return Integer.parseInt(AppView.sc.nextLine());
    }

    public static boolean doesContinueToInputStudent() {
        AppView.output("성적을 입력하려면 'Y‘ 또는 ‘y’ 를, 종료하려면 다른 아무 키나 치시오: ");

        String line = null;
        do {
            line = AppView.sc.nextLine();
        } while (line.equals(""));

        char answer = line.charAt(0);
        return ((answer == 'y') || (answer == 'Y'));
    }


    public static int inputScore() {
        while (true) {
            try {
                AppView.output("- 점수를 입력하시오: ");
                int score = AppView.inputInt();
                return score;
            } catch (NumberFormatException e) {
                AppView.outputLine("(오류) 정수가 입력되지 않았습니다.");
            }
        }
    }

    public static String inputStudentNumber() {
        AppView.output("- 학번을 입력하시오: ");
        return sc.nextLine();
    }

}
