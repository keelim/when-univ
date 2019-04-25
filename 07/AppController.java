public class AppController {
    private static final int STACK_CAPACITY = 10; // 비공개 변수들
    private ArrayList<Character> _stack;
    private int _inputChars;   // 입력된 문자의 개수
    private int _pushedChars; // 삽입된 문자의 개수
    private int _ignoredChars; // 무시된 문자의 개수


    public ArrayList<Character> stack() {
        return _stack;
    }

    public void setStack(ArrayList<Character> _stack) {
        this._stack = _stack;
    }

    public int inputChars() {
        return _inputChars;
    }

    public void setInputChars(int _inputChars) {
        this._inputChars = _inputChars;
    }

    public int pushedChars() {
        return _pushedChars;
    }

    public void setPushedChars(int _pushedChars) {
        this._pushedChars = _pushedChars;
    }

    public int ignoredChars() {
        return _ignoredChars;
    }

    public void setIgnoredChars(int _ignoredChars) {
        this._ignoredChars = _ignoredChars;
    }

    public AppController() {
        this.setStack(new ArrayList<Character>(AppController.STACK_CAPACITY));
        this.setInputChars(0);
        this.setPushedChars(0);
        this.setIgnoredChars(0);
    }

    // 횟수 계산
    private void countInputChar() {

    }

    private void countIgnoredChar() {
    }

    private void countPushedChar() {
    }

    // 스택 수행 관련
    private void pushToStack(char aCharForPush) {
        if (this.stack().isFull()) {
            AppView.outputLine("(오류) 스택이 꽉차서 더 이상 넣을 수 없습니다. ");
        } else {
            if (this.stack().push(Character.valueOf(aCharForPush))) {
                AppView.outputLine("[Push]  삽입된 원소는 " + aCharForPush + "입니다. ");
            } else {
                AppView.outputLine("(오류) 스택에 넣는 동안 오류가 발생하였습니다. ");
            }

        }
    }

    private void popOne() {
        if (this.stack().isEmpty()) {
            AppView.outputLine("[Pop.Empty] 스택에 삭제할 원소가 없습니다. ");

        } else {
            Character poppedChar = this.stack().pop();
            if (poppedChar == null) {
                AppView.outputLine("(오류) 스택에서 삭제하는 동안에 오류가 발생하였습니다. ");
            } else {
                AppView.outputLine("[Pop] 삭제된 원소는 '" + poppedChar + "' 입니다. ");
            }
        }
    }

    private void popN(int numberOfCharsToBePopped) {
        if (numberOfCharsToBePopped == 0) {
            AppView.outputLine("[Pops] 삭제할 원소의 개수가 0 개 입니다. ");
        } else {
            int count = 0;
            while (count < numberOfCharsToBePopped && (!this.stack().isEmpty())) {
                Character poppedChar = this.stack().pop();
                if (poppedChar == null) {
                    AppView.outputLine("(오류) 스택에서 삭제하는 동안에 오류가 발생하였습니다. ");

                } else {
                    AppView.outputLine("[Pops] 삭제된 원소는 '" + poppedChar + "' 입니다. ");
                }
                count++;
            }
            if (count < numberOfCharsToBePopped) {
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
    private void showAllFromBottom() {
        AppView.output("[Stack] <Bottom>");
        for (int order = 0; order < this.stack().size(); order++) {
            AppView.output(this.stack().elementAt(order).toString() + " ");
        }
    }

    private void showAllFromTop() { //todo 구현은 완료 정상적으로 작동을 하는지는 확인이 필요
        AppView.output("[Stack] <Top>");
        for (int order = this.stack().size() - 1; order >= 0; order++) {
            AppView.output(this.stack().elementAt(order).toString() + " ");
        }
    }

    private void showTopElement() { //수정은 필요해 보인다.
        AppView.output("[Stack] Top Element 입니다. ");
        AppView.output("top element" + this.stack().peek());
    }

    private void showStackSize() {
        AppView.output("Stack의 사이즈는" + this.stack().size() + "입니다. ");
    }

    private void showStatistics() {
        AppView.outputLine("");
        AppView.outputLine("<스택 사용 통계>");
        AppView.outputLine("- 입력된 문자는 " + this.inputChars() + "개 입니다.");

        AppView.outputLine("- 정상 처리된 문자는 " + (this.inputChars() - this.ignoredChars()) + "개 입니다.");
        AppView.outputLine("- 무시된 문자는" + this.ignoredChars() + "개 입니다. ");
        AppView.outputLine("- 삽입된 문자는  " + this.pushedChars() + "개 입니다. ");


    }

    // 입력 관련
    private char inputChar() {
        AppView.output("? 문자를 입력하시오: ");
        return AppView.inputChar();
    }


    public void run() {
        AppView.outputLine("<<< 스택 기능 확인 프로그램을 시작합니다. >>>");
        AppView.outputLine("");

        char input = this.inputChar();
        while (input != '!') {
            this.countInputChar();
            if (Character.isAlphabetic(input)) {//알파벳 검사
                this.pushToStack(input);
                this.countPushedChar();
            } else if (Character.isDigit(input)) { //숫자 문자 검사
                this.popN(Character.getNumericValue(input));
            } else if (input == '-') {
                this.popOne();
            } else if (input == '#') {
                this.showStackSize();
            } else if (input == '/') {
                this.showAllFromBottom();
            } else if (input == '\\') {
                this.showAllFromTop();
            } else if (input == '^') {
                this.showTopElement();
            } else {
                AppView.outputLine("[ignore] 의미 없는 문자가 입력되었습니다. ");
                this.countIgnoredChar();
            }
            input = this.inputChar();

        }
        this.quitStackProcessing();

        this.showStatistics();
        AppView.outputLine("");
        AppView.outputLine("<<< 스택 기능 확인 프로그램을 종료합니다. >>>");

    }
}
