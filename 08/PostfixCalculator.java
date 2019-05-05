public class PostfixCalculator {
    private Stack<Integer> _valueStack;

    public Stack<Integer> valueStack() {
        return _valueStack;
    } //getter

    public void setValueStack(Stack<Integer> _valueStack) {
        this._valueStack = _valueStack;
    } //setter

    public PostfixCalculator(int givenStackCapcity) {
        _valueStack = new ArrayList<>(givenStackCapcity);
    } //constructor

    public int evaluate(String aPostfixExpression) throws CalculatorException { //계산

        if (aPostfixExpression == null || aPostfixExpression.length() == 0) { //null 값인지 길이가 0인지 확인
            throw new CalculatorException((CalculatorError.PostfixError_NoExpression)); //에러 핸들링
        }

        this.valueStack().clear(); //Stack 초기화
        char token; //토큰 정의

        for (int current = 0; current < aPostfixExpression.length(); current++) { //길이까지 반복을 한다.
            token = aPostfixExpression.charAt(current); //후위식 토큰을 얻는다.

            if (Character.isDigit(token)) {
                int tokenValue = Character.getNumericValue(token);

                if (this.valueStack().isFull()) { //꽉 차 있는지 확인
                    throw new CalculatorException(CalculatorError.PostfixError_TooLongExpression); //꽉차 있으면 오류
                } else {
                    this.valueStack().push(Integer.valueOf(tokenValue)); //아니면 push
                }

            } else {
                CalculatorError error = this.executeBinaryOperator(token); //에러 발생
                if (error != CalculatorError.PostfixError_None) {
                    throw new CalculatorException(error);
                }
            }
            this.showTokenAndValueStack(token);
        }

        if (this.valueStack().size() == 1) { //스택 사이즈가 1일 경우 꺼낸다.
            return (this.valueStack().pop().intValue());
        } else {
            throw new CalculatorException(CalculatorError.PostfixError_TooManyValues); //오류 시 오류 발생
        }
    }

    private void showTokenAndValueStack(char aToken) { //Bottom - Top 까지 value 스택 안에 원소들을 출력
        AppView.outputDebugMessage(aToken + " :ValueStack <Bottom> ");
        for (int i = 0; i < this.valueStack().size(); i++) {
            AppView.outputDebugMessage(
                    ((ArrayList<Integer>) this.valueStack()).elementAt(i).intValue() + " ");
        }
        AppView.outputLineDebugMessage("<Top>");
    }

    private CalculatorError executeBinaryOperator(char anOperator) {
        if (this.valueStack().size() < 2) { //스택 값이 2 이하일시 오류 발생
            return CalculatorError.PostfixError_TooFewValues;
        }

        int operand1 = this.valueStack().pop().intValue(); //스택에서 pop하여 참조
        int operand2 = this.valueStack().pop().intValue();//스택에서 pop하여 참조
        int calculated = 0;
        switch (anOperator) {
            case '^': //제곱 연산
                calculated = (int) Math.pow((double) operand2, (double) operand1);
                break;
            case '*': //곱 연산
                calculated = operand2 * operand1;
                break;
            case '/': //나눗셈 연산
                if (operand1 == 0) {
                    AppView.outputLineDebugMessage(anOperator + " : (DivideByZero) " + operand2 + " " + anOperator + " " + operand1);
                    return CalculatorError.PostfixError_DivideByZero;
                } else {
                    calculated = operand2 / operand1;
                }
                break;
            case '%': //나머지 연산
                if (operand1 == 0) {
                    AppView.outputLineDebugMessage(anOperator + " : (DivideByZero) " + operand2 + " " + anOperator + " " + operand1);
                    return CalculatorError.PostfixError_DivideByZero;
                } else {
                    calculated = operand2 % operand1;
                }
                break;
            case '+': //덧셈 연산
                calculated = operand2 + operand1;
                break;
            case '-': //뺄셈 연산
                calculated = operand2 - operand1;
                break;
            default:
                return CalculatorError.PostfixError_UnknownOperator;
        }
        this.valueStack().push(Integer.valueOf(calculated)); //연산 값을 다시 스택으로

        return CalculatorError.PostfixError_None;
    }
}
