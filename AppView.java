import java.util.Scanner;

public class AppView {
    private static Scanner sc = new Scanner(System.in);



    private AppView() {
        //TODO
    }

    public static void outputDebugMessage(String message) {
        //TODO
    }

    public static void outputLine(String message) {
        System.out.println(message + "\n");
    }

    public static void output(String message){
        //todo
    }



    public static int inputInteger() throws NumberFormatException{
        return Integer.parseInt(AppView.sc.next());
    }

}
