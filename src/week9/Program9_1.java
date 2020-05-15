package week9;

import java.util.Scanner;

public class Program9_1 {
    static final Scanner sc = new Scanner(System.in);
    private static final int MAX_SIZE = 100;

    public static void main(final String[] args) {
        int num;
        int count = 0;
        double average = 0;
        int[] scores = new int[MAX_SIZE];

        num = inputScore();
        while (num >= 0) {

            if (num > 100) {
                System.out.println("오류: 100이 넘어서, 정상적인 점수가 아닙니다.");
                num = inputScore();
                continue;
            }
            scores[count] = num;
            count++;

            num = inputScore();
        }
        System.out.println("음의 점수가 입력되어 입력을 종료합니다.\n");

        System.out.println("모두 " + count + " 명의 성적이 입력되었습니다.");

        average = calcAverage(scores, count);

        System.out.println("평균은 " + average + " 입니다.\n\n");
        int temp = 0;
        System.out.println("입력된 성적은 다음과 같습니다.");
        for (int i = 0; i < count; i++) {
            if (scores[i] >= average) {
                System.out.println("[" + i + "] " + scores[i] + " (평균 이상입니다.)");
                temp++;
            }

            else
                System.out.println("[" + i + "] " + scores[i] + " (평균 미만입니다.)");
        }

        System.out.println("\n평균 이상인 학생의 수는 " + temp + " 명 입니다.");

        calcMax(scores, count);
        calcMin(scores, count);

        selectionSort(scores, count);

        System.out.println("\n성적순은 다음과 같습니다.");

        for(int i=0; i<count;i++){
            System.out.println("["+i+"] "+scores[i]);
        }

        System.out.println("프로그램을 종료합니다.");

    }

    private static void selectionSort(int[] elements, int size) {
        int left = 0;
        int right = size - 1;
        while (left < right) {
            int selected = left;
            int current = left + 1;
            while (current <= right) {
                if (elements[current] > elements[selected]) {
                    selected = current;
                }
                current++;
            }
            // elements[left] 와 elements[selected] 의 값 맞바꾸기
            int selectedValue = elements[selected];
            elements[selected] = elements[left];
            elements[left] = selectedValue;
            left++;
        }
    }

    private static void calcMax(int[] scores, int count) {
        int max = scores[0];

        for (int i = 0; i < count; i++) {
            max = (scores[i] >= max) ? scores[i] : max;
        }
        System.out.println("최고점은 " + max + " 점입니다.");
    }

    private static void calcMin(int[] scores, int count) {
        int min = scores[0];
        for (int i = 0; i < count; i++) {
            min = (scores[i] >= min) ? min : scores[i];
        }
        System.out.println("최저점은 " + min + " 점입니다.");
    }

    private static int inputScore() {
        System.out.print("-점수를 입력하시오: ");
        return sc.nextInt();
    }

    private static double calcAverage(int[] element, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += element[i];
        }
        return sum / size;
    }
}