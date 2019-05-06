import java.util.Arrays;

public class Calculator {

    private static final int MAX_EXPRESSION_LENGTH = 10;

    private Stack<Character> _operatorStack;
    private String _infixExpression;
    private String _postfixExpression;
    private PostfixCalculator _postfixCalculator;


    public Stack<Character> operatorStack() {
        return _operatorStack;
    }//getter

    public void setOperatorStack(Stack<Character> _operatorStack) {
        this._operatorStack = _operatorStack;
    }//setter

    public String infixExpression() {
        return _infixExpression;
    }//getter

    public void setInfixExpression(String _infixExpression) {
        this._infixExpression = _infixExpression;
    }//setter

    public String postfixExpression() {
        return _postfixExpression;
    } //getter

    public void setPostfixExpression(String _postfixExpression) {
        this._postfixExpression = _postfixExpression;
    } //setter

    public PostfixCalculator postfixCalculator() {
        return _postfixCalculator;
    } //getter

    public void setPostfixCalculator(PostfixCalculator _postfixCalculator) {
        this._postfixCalculator = _postfixCalculator;
    } //setter

    public Calculator() { //constructor
        this.setOperatorStack(new ArrayList<Character>(Calculator.MAX_EXPRESSION_LENGTH));
        this.setPostfixCalculator(new PostfixCalculator(Calculator.MAX_EXPRESSION_LENGTH));
    }

    private void showTokenPostfixExpression(char aToken, char[] aPostfixExpressionArray) { //후위식 토큰을 보여준다.
        AppView.outputDebugMessage(aToken + " :(Postfix) "); //후위식 토큰 출력
        AppView.outputLineDebugMessage(new String(aPostfixExpressionArray));
    }

    private int inComingPrecedence(Character aToken) { //우선 순위 처리
        switch (aToken.charValue()) {
            case '(':
                return 20;
            case ')':
                return 19;
            case '^':
                return 17;
            case '*':
                return 13;
            case '/':
                return 13;
            case '%':
                return 13;
            case '+':
                return 12;
            case '-':
                return 12;
            default:
                return -1;
        }
    }

    private int inStackPrecedence(Character aToken) { //Stack 안에서 우선순위 처리
        switch (aToken.charValue()) {
            case '(':
                return 0;
            case ')':
                return 19;
            case '^':
                return 16;
            case '*':
                return 13;
            case '/':
                return 13;
            case '%':
                return 13;
            case '+':
                return 12;
            case '-':
                return 12;
            default:
                return -1;
        }

    }

    private CalculatorError infixToPostfix() {
        char[] postfixExpressionArray = new char[this.infixExpression().length()]; //배열 생성
        Arrays.fill(postfixExpressionArray, ' '); //배열을 빈값으로 초기화

        Character currentToken, poppedToken, topToken;
        this.operatorStack().clear(); //초기화
        int p = 0;

        for (int i = 0; i < this.infixExpression().length(); i++) { //반복을 통하여 토큰 get
            currentToken = this.infixExpression().charAt(i);

            if (Character.isDigit(currentToken.charValue())) { //isDigit() 메소드로 문자 숫자 구분
                postfixExpressionArray[p++] = currentToken;
                this.showTokenPostfixExpression(currentToken, postfixExpressionArray);

            } else {

                if (currentToken == ')') {
                    this.showTokenAndMessage(currentToken, "왼쪽 괄호가 나타날 까지 스택에서 꺼내어 출력");
                    poppedToken = this.operatorStack().pop();
                    while (poppedToken != null && poppedToken.charValue() != '(') { //반복을 통하여 pop 처리
                        postfixExpressionArray[p++] = poppedToken.charValue();
                        this.showOperatorStack("Popped");
                        this.showTokenPostfixExpression(poppedToken, postfixExpressionArray);
                        poppedToken = this.operatorStack().pop();
                    }

                    if (poppedToken == null) { //오류 핸들링
                        return CalculatorError.InfixError_MissingLeftParen;
                    }

                    this.showOperatorStack("Popped");
                } else {
                    int inComingPrecedence = this.inComingPrecedence(currentToken.charValue());

                    if (inComingPrecedence < 0) {
                        AppView.outputLineDebugMessage(currentToken + " : (Unknown Operator)");
                        return CalculatorError.InfixError_UnknownOperator;
                    }
                    this.showTokenAndMessage( //토큰에 따른 메시지 출력
                            currentToken, "입력 연산자보다 순위가 높지 않은 연산자를 스택에서 꺼내어 출력");
                    topToken = this.operatorStack().peek();

                    while (topToken != null && this.inStackPrecedence(topToken) >= inComingPrecedence) { //우선 순위 확인을 하고 반복 실행
                        poppedToken = this.operatorStack().pop(); //pop
                        postfixExpressionArray[p++] = poppedToken; //배열에 토큰을 넣는다.
                        this.showOperatorStack("Popped");
                        this.showTokenPostfixExpression(poppedToken, postfixExpressionArray); //토큰 출력
                        topToken = this.operatorStack().peek(); //top 확인
                    }

                    if (this.operatorStack().isFull()) { //꽉차 있는지 확인
                        this.showOperatorStack("Fulled");
                        return CalculatorError.InfixError_TooLongExpression;
                    }

                    this.operatorStack().push(currentToken); //push
                    this.showOperatorStack("Pushed"); //pushed 관련 메시지 출력
                }
            }

        }
        //////////////////////////////////////////// infix의 처리//////////////////////////////////////////////////////
        AppView.outputLineDebugMessage("(End of infix expression: 스택에서 모든 연산자를 꺼내어 출력");

        while (!this.operatorStack().isEmpty()) { //비어 있는지 확인
            poppedToken = this.operatorStack().pop(); //popped 관련 메시지 출력
            this.showOperatorStack("Popped");

            if (poppedToken == '(') { //괄호 확인
                return CalculatorError.InfixError_MissingRightParen;
            }
            postfixExpressionArray[p++] = poppedToken;
            this.showTokenPostfixExpression(poppedToken, postfixExpressionArray); //후위식 출력
        }
        this.setPostfixExpression(new String(postfixExpressionArray).trim()); //후위식 설정

        return CalculatorError.InfixError_None; // enum 값 리턴
    }

    private void showOperatorStack(String operator) {
        AppView.outputDebugMessage(" : " + operator + "OperatorStack <Bottom> ");
        for (int i = 0; i < this.operatorStack().size(); i++) { //반복을 통하여 연산자 스택 확인
            AppView.outputDebugMessage(
                    ((ArrayList<Character>) this.operatorStack()).elementAt(i) + " ");
        }
        AppView.outputLineDebugMessage("<Top>");
    }

    private void showTokenAndMessage(Character currentToken, String message) {
        AppView.outputLineDebugMessage(currentToken + " : (입력 연산자보다 순위가 높지 않은 연산자를 스택에서 꺼내어 출력)");
    }

    public int evaluate(String anInfixExpression) throws CalculatorException { //결과값
        this.setInfixExpression(anInfixExpression); //파라미터로 전달된 infix 설정
        AppView.outputLineDebugMessage("\n[Infix to Postfix] " + anInfixExpression); //infix 출력
        if (this.infixExpression() == null || this.infixExpression().length() == 0) { //해당 시 enum 값 throw
            throw new CalculatorException(CalculatorError.InfixError_NoExpression);
        }

        CalculatorError infixError = this.infixToPostfix(); //에러 설정
        if (infixError == CalculatorError.InfixError_None) { //에러가 없는지 확인
            AppView.outputDebugMessage("\n[Evaluate Postfix] " + this.postfixExpression()); //후위식 ㅣ설정 및 출력
            return this.postfixCalculator().evaluate(this.postfixExpression()); //결과 값 리턴
        } else {
            throw new CalculatorException((infixError));
        }

    }
}
