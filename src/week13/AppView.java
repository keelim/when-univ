package week13;

import java.util.Scanner;

public class AppView {
    private Scanner _scanner;

    public AppView() {
        this._scanner = new Scanner(System.in);
    }

    public char inputChar() {
        String line = this._scanner.next();
        return (line.charAt(0));
    }

    public String inputString(){
        String line = this._scanner.next();
        return line;
    }

    public int inputInt(){
        return this._scanner.nextInt();
    }

    public void outputLine(String aMessage){
        System.out.println(aMessage);
    }

    public void output(String aMessage){
        System.out.print(aMessage);
    }
}
