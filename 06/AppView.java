import java.util.Scanner;

public class AppView {
    private static Scanner sc = new Scanner(System.in);

    public static int inputScore() {
        while (true) {
            try {
                AppView.output("- 점수를 입력하시오 (0..100): ");
                int score = AppView.inputInt();
                return score;
            } catch (NumberFormatException e) {
                AppView.outputLine("(오류) 정수가 입력되지 않았습니다.");
            }
        }

    }

    private static int inputInt() throws NumberFormatException {
        return Integer.parseInt(AppView.sc.nextLine());
    }

    public static void output(String aMessage) {
        System.out.println(aMessage);
    }

    public static void outputLine(String aMessage) {
        System.out.println(aMessage);

    }


    public static void outputScore(int aScore) {
        System.out.println("점수 " + aScore + "입니다. ");
    }


    public static void outputNumberOfStudents(int aNumberOfStudents) {
        //학급 학생 수 출력
    }

    public static void outputHighestScore(int aScore) {
        //학급 최고 점수 출력
    }

    public static void outputLowestScore(int aScore) {
        //최저점 출력
    }


    public static void outputAverageScore(double anAverageScore) {
        //평균값을 출력
    }


    public static void outputNumberOfStudentsAboveAverage(int aNumberOfStudents) {
        //평균 이상인 학생 수 출력
    }


    public static void outputNumberOfStudentsForGrade(char aGrade, int aNumberOfStudents) {

    }


    public static void outputStudentInfo(int aScore) {
        //학생들의 점수 출력
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


}
