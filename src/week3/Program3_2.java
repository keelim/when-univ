package week3;

import java.util.Scanner;

public class Program3_2{
    public static void main(String[] args) {
        int givenN, count = 1, sum = 1;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("<< 1부터 주어진 수 까지의 합을 계산하는 프로그램을 시작합니다.>>");
        System.out.print("- N 값을 입력하시오: " );
        givenN = sc.nextInt();
        if(givenN<0){
            System.out.println("[오류] 주어진 N 값이 1 보다 작아서 합을 계산할 수 없습니다.");
        } else{
            while(count<givenN){
                count++;
                sum+=count;
            }
            System.out.println("합계는 "+sum+ " 입니다.");
        }
        

        System.out.println("\n<< 1 부터 주어진 수까지의 합을 계산하는 프로그램을 종료합니다. >>");
    }
}