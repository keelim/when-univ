public class AppController {
    private static final int STACK_CAPACITY = 10; // 비공개 변수들
    private ArrayList<Character> _stack;
    private int _inputChars;   // 입력된 문자의 개수
    private int _pushedChars; // 삽입된 문자의 개수
    private int _ignoredChars; // 무시된 문자의 개수


    public ArrayList<Character> stack() { //constructor
        return _stack;
    } //getter

    public void setStack(ArrayList<Character> _stack) { //setter
        this._stack = _stack;
    } //setter

    public int inputChars() { //getter
        return _inputChars;
    }//getter

    public void setInputChars(int _inputChars) {//setter
        this._inputChars = _inputChars;
    } //setter

    public int pushedChars() { //getter
        return _pushedChars;
    } //getter

    public void setPushedChars(int _pushedChars) { //setter
        this._pushedChars = _pushedChars;
    } //setter

    public int ignoredChars() { //getter
        return _ignoredChars;
    } //getter

    public void setIgnoredChars(int _ignoredChars) { //setter
        this._ignoredChars = _ignoredChars;
    } //setter

    public AppController() { //constructor
        this.setStack(new ArrayList<Character>(AppController.STACK_CAPACITY));
        this.setInputChars(0);
        this.setPushedChars(0);
        this.setIgnoredChars(0);
    }

    // 횟수 계산
    private void countInputChar() {
        this.setInputChars(this.inputChars() + 1);
    } //inputchar++

    private void countIgnoredChar() {
        this.setIgnoredChars(this.ignoredChars() + 1);
    } //ignorechar++

    private void countPushedChar() {
        this.setPushedChars(this.pushedChars() + 1);
    } // //pushedchar++

    // 스택 수행 관련
    private void pushToStack(char aCharForPush) {
        if (this.stack().isFull()) { //꽉 차있는지 확인
            AppView.outputLine("(오류) 스택이 꽉차서 더 이상 넣을 수 없습니다. "); //오류 메시지
        } else {
            if (this.stack().push(Character.valueOf(aCharForPush))) { //값을 다시 넣는다.
                AppView.outputLine("[Push]  삽입된 원소는 " + aCharForPush + "입니다. ");
            } else {
                AppView.outputLine("(오류) 스택에 넣는 동안 오류가 발생하였습니다. ");
            }

        }
    }

    private void popOne() {
        if (this.stack().isEmpty()) { //비어 있는지 확인
            AppView.outputLine("[Pop.Empty] 스택에 삭제할 원소가 없습니다. ");

        } else {
            Character poppedChar = this.stack().pop(); //엘리먼트를 pop
            if (poppedChar == null) { //null check
                AppView.outputLine("(오류) 스택에서 삭제하는 동안에 오류가 발생하였습니다. "); //오류 메시지 출력
            } else {
                AppView.outputLine("[Pop] 삭제된 원소는 '" + poppedChar + "' 입니다. "); //pop 원소 출력
            }
        }
    }

    private void popN(int numberOfCharsToBePopped) { // n 개 원소 pop()
        if (numberOfCharsToBePopped == 0) { //0일 경우
            AppView.outputLine("[Pops] 삭제할 원소의 개수가 0 개 입니다. ");
        } else {
            int count = 0;
            while (count < numberOfCharsToBePopped && (!this.stack().isEmpty())) { //isEmpty check, loop
                Character poppedChar = this.stack().pop(); //count 만큼 pop
                if (poppedChar == null) { //null check
                    AppView.outputLine("(오류) 스택에서 삭제하는 동안에 오류가 발생하였습니다. "); //오류 메시지 출력

                } else {
                    AppView.outputLine("[Pops] 삭제된 원소는 '" + poppedChar + "' 입니다. "); //삭제된 원소 출력
                }
                count++;
            }
            if (count < numberOfCharsToBePopped) { //원소가 없을 경우
                AppView.outputLine("[Pops.Empty] 스택에 더이상 삭제할 원소가 없습니다. ");
            }
        }
    }

    private void quitStackProcessing() {
        AppView.outputLine("");
        AppView.outputLine("<스택을 비우고 사용을 종료합니다.>");
        this.showAllFromBottom();
        this.popN(this.stack().size());
    }

    // 출력 관련
    private void showAllFromBottom() { //Stack Bottom ~ Top 까지 출력
        AppView.output("[Stack] <Bottom> ");
        for (int order = 0; order < this.stack().size(); order++) { //0~top
            AppView.output(this.stack().elementAt(order).toString() + " ");
        }
        AppView.outputLine(" <Top>");
    }

    private void showAllFromTop() { //Stack Top ~ Bottom
        AppView.output("[Stack] <Top> ");
        for (int order = this.stack().size() - 1; order >= 0; order--) { //top~0
            AppView.output(this.stack().elementAt(order).toString() + " ");
        }
        AppView.outputLine(" <Bottom>");

    }

    private void showTopElement() { //Top Element출력
        if (this.stack().isEmpty()) {
            AppView.outputLine("[Pop.Empty] 스택에 삭제할 원소가 없습니다. ");
        } else {
            AppView.outputLine("[Top] 스택의 Top 원소는 '" + this.stack().peek() + "' 입니다. ");
        }
    }

    private void showStackSize() {
        AppView.outputLine("Stack에는 현재 " + this.stack().size() + " 개의 원소가 있습니다.");
    }

    private void showStatistics() { //통계함수 출력
        AppView.outputLine("");
        AppView.outputLine("<스택 사용 통계>");
        AppView.outputLine("- 입력된 문자는 " + this.inputChars() + "개 입니다.");
        AppView.outputLine("- 정상 처리된 문자는 " + (this.inputChars() - this.ignoredChars()) + "개 입니다.");
        AppView.outputLine("- 무시된 문자는" + this.ignoredChars() + "개 입니다. ");
        AppView.outputLine("- 삽입된 문자는  " + this.pushedChars() + "개 입니다. ");
    }

    // 입력 관련
    private char inputChar() { //문자를 입력 받는다.
        AppView.outputLine("? 문자를 입력하시오: ");
        return AppView.inputChar();
    }


    public void run() { //AppController run
        AppView.outputLine("<<< 스택 기능 확인 프로그램을 시작합니다. >>>");
        AppView.outputLine("");

        char input = this.inputChar(); //문자 입력

        while (input != '!') {
            this.countInputChar();
            if (Character.isAlphabetic(input)) {//알파벳 검사
                this.pushToStack(input);
                this.countPushedChar();
            } else if (Character.isDigit(input)) { //숫자 문자 검사
                this.popN(Character.getNumericValue(input)); //n 개 pop
            } else if (input == '-') {
                this.popOne(); //1개 pop
            } else if (input == '#') {
                this.showStackSize(); //Stack size 출력
            } else if (input == '/') {
                this.showAllFromBottom(); //Bottom 부터 출력
            } else if (input == '\\') {
                this.showAllFromTop(); //Top 부터 출력
            } else if (input == '^') { // peek
                this.showTopElement();
            } else {
                AppView.outputLine("[ignore] 의미 없는 문자가 입력되었습니다. ");
                this.countIgnoredChar();
            }
            input = this.inputChar();

        }
        this.quitStackProcessing(); //Stack processing 종료

        this.showStatistics(); //통계 함수 출력
        AppView.outputLine("");
        AppView.outputLine("<<< 스택 기능 확인 프로그램을 종료합니다. >>>");

    }
}
