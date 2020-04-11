package week5;

public class Program5_2 {
    public static void main(String[] args) {
        System.out.println("<< Sine 값 출력 프로그램을 시작합니다. >>\n");

        int n = 0; // 도수
        for (n = 1; n <= 180; n++) {
            double x = ((double) n) * (3.141592 / 180.0);
            double y = Math.sin(x);

            System.out.println("Sine(" + n + "도) 는 " + y + " 입니다.");

        }

        System.out.println("\n\nMath.PI version");
        for (n = 1; n <= 180; n++) {
            double x = ((double) n) * (Math.PI / 180.0);
            double y = Math.sin(x);

            System.out.println("Sine(" + n + "도) 는 " + y + " 입니다.");

        }

        System.out.println("\n<< Sine 값 출력 프로그램을 종료합니다.. >>");
    }
}