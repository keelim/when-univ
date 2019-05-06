

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
        AppView.outputDebugMessage(aToken + " :(Postfix) ");
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
        char[] postfixExpressionArray = new char[this.infixExpression().length()];
        Arrays.fill(postfixExpressionArray, ' '); //배열을 빈값으로 초기화

        Character currentToken, poppedToken, topToken;
        this.operatorStack().clear();
        int p = 0;

        for (int i = 0; i < this.infixExpression().length(); i++) {
            currentToken = this.infixExpression().charAt(i);

            if (Character.isDigit(currentToken.charValue())) {
                postfixExpressionArray[p++] = currentToken;
                this.showTokenPostfixExpression(currentToken, postfixExpressionArray);

            } else {

                if (currentToken == ')') {
                    this.showTokenAndMessage(currentToken, "왼쪽 괄호가 나타날 까지 스택에서 꺼내어 출력");
                    poppedToken = this.operatorStack().pop();
                    while (poppedToken != null && poppedToken.charValue() != '(') {
                        postfixExpressionArray[p++] = poppedToken.charValue();
                        this.showOperatorStack("Popped");
                        this.showTokenPostfixExpression(poppedToken, postfixExpressionArray);
                        poppedToken = this.operatorStack().pop();
                    }

                    if (poppedToken == null) {
                        return CalculatorError.InfixError_MissingLeftParen;
                    }

                    this.showOperatorStack("Popped");
                } else {
                    int inComingPrecedence = this.inComingPrecedence(currentToken.charValue());

                    if (inComingPrecedence < 0) {
                        AppView.outputLineDebugMessage(currentToken + " : (Unknown Operator)");
                        return CalculatorError.InfixError_UnknownOperator;
                    }
                    this.showTokenAndMessage(
                            currentToken, "입력 연산자보다 순위가 높지 않은 연산자를 스택에서 꺼내어 출력");
                    topToken = this.operatorStack().peek();

                    while (topToken != null && this.inStackPrecedence(topToken) >= inComingPrecedence) {
                        poppedToken = this.operatorStack().pop();
                        postfixExpressionArray[p++] = poppedToken;
                        this.showOperatorStack("Popped");
                        this.showTokenPostfixExpression(poppedToken, postfixExpressionArray);
                        topToken = this.operatorStack().peek();
                    }

                    if (this.operatorStack().isFull()) {
                        this.showOperatorStack("Fulled");
                        return CalculatorError.InfixError_TooLongExpression;
                    }

                    this.operatorStack().push(currentToken);
                    this.showOperatorStack("Pushed");
                }
            }

        }
        AppView.outputLineDebugMessage("(End of infix expression: 스택에서 모든 연산자를 꺼내어 출력");

        while (!this.operatorStack().isEmpty()) {
            poppedToken = this.operatorStack().pop();
            this.showOperatorStack("Popped");

            if (poppedToken == '(') {
                return CalculatorError.InfixError_MissingRightParen;
            }
            postfixExpressionArray[p++] = poppedToken;
            this.showTokenPostfixExpression(poppedToken, postfixExpressionArray);
        }
        this.setPostfixExpression(new String(postfixExpressionArray).trim());

        return CalculatorError.InfixError_None;
    }

    private void showOperatorStack(String operator) {
        AppView.outputDebugMessage(" : " + operator + "OperatorStack <Bottom> ");
        for (int i = 0; i < this.operatorStack().size(); i++) {
            AppView.outputDebugMessage(
                    ((ArrayList<Character>) this.operatorStack()).elementAt(i) + " ");
        }
        AppView.outputLineDebugMessage("<Top>");
    }

    private void showTokenAndMessage(Character currentToken, String message) {
        AppView.outputLineDebugMessage(currentToken + " : (입력 연산자보다 순위가 높지 않은 연산자를 스택에서 꺼내어 출력)");
    }

    public int evaluate(String anInfixExpression) throws CalculatorException {
        this.setInfixExpression(anInfixExpression);
        AppView.outputLineDebugMessage("\n[Infix to Postfix] " + anInfixExpression);
        if (this.infixExpression() == null || this.infixExpression().length() == 0) {
            throw new CalculatorException(CalculatorError.InfixError_NoExpression);
        }

        CalculatorError infixError = this.infixToPostfix();
        if (infixError == CalculatorError.InfixError_None) {
            AppView.outputDebugMessage("\n[Evaluate Postfix] " + this.postfixExpression());
            return this.postfixCalculator().evaluate(this.postfixExpression());
        } else {
            throw new CalculatorException((infixError));
        }

    }
}
