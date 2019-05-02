import java.util.Scanner;

public class AppView {
    private static Scanner sc = new Scanner(System.in);

    public static int inputScore() { //점수 입력
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

    private static int inputInt() throws NumberFormatException { //정수 입력 --> inputScore 로 넘긴다.
        return Integer.parseInt(AppView.sc.nextLine());
    }

    public static void output(String aMessage) {
        System.out.println(aMessage);

    } //메시지 출력

    public static void outputLine(String aMessage) { //메시지 출력
        System.out.println(aMessage);

    }


    public static void outputScore(int aScore) {
        System.out.println("점수 " + aScore + "입니다. ");
    } //점수 출력


    public static void outputNumberOfStudents(int aNumberOfStudents) {
        //학급 학생 수 출력
        System.out.println("학급 학생 수: " + aNumberOfStudents);
    }

    public static void outputHighestScore(int aScore) {
        //학급 최고 점수 출력
        System.out.println("학급 최고 점수 : " + aScore);
    }

    public static void outputLowestScore(int aScore) {
        //최저점 출력
        System.out.println("학급 최저 점수: " + aScore);
    }


    public static void outputAverageScore(double anAverageScore) {
        //평균값을 출력
        System.out.println("학급 평균: " + anAverageScore);
    }


    public static void outputNumberOfStudentsAboveAverage(int aNumberOfStudents) {
        //평균 이상인 학생 수 출력
        System.out.println("평균 이상인 학생 수 : " + aNumberOfStudents);

    }


    public static void outputNumberOfStudentsForGrade(char aGrade, int aNumberOfStudents) { //학점의 학생 수 출력
        System.out.println(aGrade + " 학점의 학생 수는 " + aNumberOfStudents + "입니다. ");

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
