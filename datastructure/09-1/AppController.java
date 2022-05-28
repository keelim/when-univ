public class AppController {
    private static final int QUEUE_CAPACITY = 10;
    // 비공개 변수들
    private Queue<Character> _queue; //만들 거야
    private int _inputChars; // 입력된 문자의 개수
    private int _addedChars; // 삽입된 문자의 개수
    private int _ignoredChars; // 무시된 문자의 개수

    public AppController() { //constructor
        this.setQueue(new CircularArrayQueue<>(AppController.QUEUE_CAPACITY));
        this.setInputChars(0);
        this.setAddedChars(0);
        this.setIgnoredChars(0);
    }

    public Queue<Character> queue() {//getter
        return _queue;
    }

    public void setQueue(Queue<Character> _queue) { //setter
        this._queue = _queue;
    }

    public int inputChars() { //getter
        return _inputChars;
    }

    public void setInputChars(int _inputChars) {//setter
        this._inputChars = _inputChars;
    }

    public int addedChars() { //getter
        return _addedChars;
    }

    public void setAddedChars(int _addedChars) { //setter
        this._addedChars = _addedChars;
    }

    public int ignoredChars() { //getter
        return _ignoredChars;
    }

    public void setIgnoredChars(int _ignoredChars) { //setter
        this._ignoredChars = _ignoredChars;
    }

    // 비공개 함수
// 횟수 계산
    private void countInputChar() { //inputChar 카운트
        this.setInputChars(this.inputChars() + 1);
    }

    private void countIgnoredChar() { //IgnoredChar 카운트
        this.setIgnoredChars(this.ignoredChars() + 1);
    }

    private void countAddedChar() { //AddedChar 카운트
        this.setAddedChars(this.addedChars() + 1);
    }

    // 큐 수행 관련
    private void addToQueue(char aCharForAdd) {

        if (this.queue().isFull()) { //Full check
            AppView.outputLine("[EnQ.Empty] 큐가 꽉 차서 더 이상 넣을 수가 없습니다.");
        } else {
            if (this.queue().enQueue(Character.valueOf(aCharForAdd))) { //enQueue를 한다
                countAddedChar();
                AppView.outputLine("enQueue 된 원소는 '" + aCharForAdd + "' 입니다.");
            } else {
                AppView.outputLine("(큐)에 넣는 동안 오류가 발생했습니다. ");
            }
        }
//큐가 가득 찬 경우
//정상적으로 enQueue가 되었을 경우
//삽입된 원소를 출력한다.
//this.countAdded() 를 호출하여 삽입된 원소의 숫자를 증가시킨다.
//삽입하는 원소의 자료형이 기본 자료형인 “char” 가 아니라, class “Character” 이다.
        //--> Character 함수 때문에 캐스팅이 된다?
    }

    private void removeOne() {
        if (this.queue().isEmpty()) { //empty check
            AppView.outputLine("[DeQ.Empty] 큐에 삭제할 원소가 없습니다. ");
        } else {
            Character removedChar = this.queue().deQueue(); //Character 객체
            if (removedChar == null) {
                AppView.outputLine("(오류) 큐에서 삭제하는 동안 오류가 발생하였습니다. ");

            } else {
                AppView.outputLine("[Deq] 삭제된 원소는 '" + removedChar + "' 입니다.");
            }
        }
    }

    private void removeN(int numberOfCharsToBeRemoved) {
        //삭제할 개수가 0 개이면 다음과 같이 출력:
        if (numberOfCharsToBeRemoved == 0) {
            AppView.outputLine("[DeQs] 삭제할 원소의 개수가 0 개입니다.");
        } else {
            int count = 0;
            while (count < numberOfCharsToBeRemoved && (!this.queue().isEmpty())) {
                Character dequeCharacter = this.queue().deQueue();
                //“deQueue()” 를 삭제하는 횟수만큼 실행하여, 매번 다음과 같이 출력한다: (삭제된 원소가 'X' 라면)
                if (dequeCharacter == null) {
                    AppView.outputLine("(오류) 큐에서 삭제하는 동안에 오류가 발생하였습니다. ");
                } else {
                    AppView.outputLine("[DeQs] 삭제된 원소는 '"+dequeCharacter+"' 입니다."); //삭제를 반복하는 동안에, 큐가 비게 되어 더 이상 삭제가 불가능하게 되면 다음과 같은 메시지를 출력한다
                }
                count++; //count 한개를 늘린다. while condition
            }
            //삭제 오류가 발생하면 다음과 같이 출력:
            if (count < numberOfCharsToBeRemoved) { //더이상 삭제할 원소가 없음을 체크
                AppView.outputLine("[DeQs.Empty] 큐에 더 이상 삭제할 원소가 없습니다.");
            }
        }


    }

    private void quitQueueProcessing() { //Queue 처리를 종료
        this.showAllFromFront(); //Front 부터 전부 출력
        removeN(this.queue().size()); //사이즈 만큼의 원소를 전부 출력
    }

    // 출력 관련
    private void showAllFromFront() {
        // 큐의 모든 원소를 Front 부터 Rear 까지 출력한다.
        // Iterator 를 사용한다.
        AppView.output("[Queue] <Front> ");
        Iterator<Character> queueIterator = this.queue().iterator(); //Iterator 를 사용
        while (queueIterator.hasNext()) { //다음 원소를 가지고 있는지 체크
            Character element = queueIterator.next();
            if (element == null){
                AppView.output(" ");
            } else {
                AppView.output(element.toString() + " ");
            }
        }
        AppView.outputLine("<Rear>");

    }

    private void showAllFromRear() {
        // 큐의 모든 원소를 Rear 부터 Front 까지 출력한다.
        // elementAt() 을 사용한다.
        AppView.output("[Queue] <Rear> ");
        for (int order = this.queue().size() - 1; order >= 0; order--) { //사이즈부터 뒤로 돌면서 출력 element 함수 이용
            AppView.output(this.queue().elementAt(order).toString() + " ");
        }
        AppView.outputLine("<Front>");

    }

    private void showFrontElement() { //front 출력
//Queue 객체의 front() 을 이용하여 Front 원소를 출력
//큐가 비어 있으면, front 원소 대신 비어 있다는 메시지 출력
        if (this.queue().isEmpty()) {
            AppView.outputLine("[Front.Empty] 큐가 비어서 맨 앞 원소가 존재하지 않습니다. ");
        } else {
            AppView.outputLine("[Front] 큐의 맨 앞 원소는 '" + this.queue().front() + "' 입니다. ");
        }
    }

    private void showRearElement() { // rear 출력
//Queue 객체의 rear() 를 이용하여 Rear 원소를 출력
//큐가 비어 있으면, Rear 원소 대신 비어 있다는 메시지 출력
        if (this.queue().isEmpty()) {
            AppView.outputLine("[Rear.Empty] 큐가 비어서 맨 뒤 원소가 존재하지 않습니다. ");
        } else {
            AppView.outputLine("[Rear] 큐의 맨 뒤 원소는 '" + this.queue().rear() + "' 입니다. ");
        }


    }

    private void showQueueSize() {
//Queue 객체의 size() 를 이용하여 원소의 개수를 출력
        AppView.outputLine("[Size] 큐에는 현재 " + this.queue().size() + " 개의 원소가 있습니다. ");

    }

    private void showStatistics() { //통계 함수 출력
        AppView.outputLine("");
        AppView.outputLine("<큐 사용 통계>");
        AppView.outputLine(" - 입력된 문자는" + inputChars() + " 개 입니다. ");
        AppView.outputLine(" - 정상 처리된 문자는" + (this.inputChars() - this.ignoredChars()) + " 개 입니다.");
        AppView.outputLine(" - 무시된 문자는" + this.ignoredChars() + " 개 입니다.");
        AppView.outputLine(" - 삽입된 문자는" + this.addedChars() + " 개 입니다.");
    }

    // 입력 관련
    private char inputChar() { //문자를 입력 한다.
        AppView.output("? 문자를 입력하시오: ");
        return AppView.inputChar();
    }

    public void run() { //AppController 실행
        AppView.outputLine("<<<큐 기능 확인 프로그램을 시작합니다 >>>");
        AppView.outputLine("");
        char input = this.inputChar();
        while (input != '!') { //특수 문자를 핸들링
            this.countInputChar();
            if (Character.isAlphabetic(input)) {
                this.addToQueue(Character.valueOf(input));
            } else if (Character.isDigit(input)) {
                this.removeN(Character.getNumericValue(input));
            } else if (input == '-') {
                this.removeOne();
            } else if (input == '#') {
                this.showQueueSize(); //Size 출력
            } else if (input == '/') {
                this.showAllFromFront(); //모든 엘리먼트 출력
            } else if (input == '\\') {
                this.showAllFromRear(); //모든 엘리먼트 출력
            } else if (input == '<') {
                this.showFrontElement(); //Front element 출력
            } else if (input == '>') {
                this.showRearElement(); //rearElement 출력
            } else {
                AppView.outputLine("[Ignore] 의미 없는 문자가 입력되었습니다.");
                this.countIgnoredChar();
            }
            input = this.inputChar();
        }
        this.quitQueueProcessing(); //queue 처리 종료
        this.showStatistics(); //통계 함수 출력
        AppView.outputLine("");
        AppView.outputLine("<<<큐 기능 확인 프로그램을 종료합니다 >>>");
    }
}
