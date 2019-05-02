public class PostfixCalculator {
    private Stack<Integer> _valueStack;


    public Stack<Integer> valueStack() {
        return _valueStack;
    }

    public void setValueStack(Stack<Integer> _valueStack) {
        this._valueStack = _valueStack;
    }

    public PostfixCalculator(int givenStackCapcity) {
        _valueStack = new ArrayList<>(givenStackCapcity);
    }

    public int evaluate(String aPostfixExpression) throws CalculatorException {
        if (aPostfixExpression == null || aPostfixExpression.length() == 0) {
            throw new CalculatorException((CalculatorError.PostfixError_NoExpression)); //에러 핸들링
        }
        this.valueStack().clear();
        char token;
        for (int current = 0; current < aPostfixExpression.length(); current++) {
            token = aPostfixExpression.charAt(current);

            if (Character.isDigit(token)) {
                int tokenValue = Character.getNumericValue(token);

                if (this.valueStack().isFull()) {
                    throw new CalculatorException(CalculatorError.PostfixError_TooLongExpression);
                } else {
                    this.valueStack().push(Integer.valueOf(tokenValue)); //애는 물어보자

                }

            } else {
                CalculatorError error = this.executeBinaryOperator(token);
                if (error != CalculatorError.PostfixError_None) {
                    throw new CalculatorException(error);
                }
            }
            this.showTokenAndValueStack(token);
        }
        if (this.valueStack().size() == 1) {
            return (this.valueStack().pop().intValue()); //애는 물어보자
        } else {
            throw new CalculatorException(CalculatorError.PostfixError_TooManyValues);
        }
    }

    private void showTokenAndValueStack(char aToken) {
        AppView.outputDebugMessage(aToken + " :ValueStack <Bottom> ");
        for (int i = 0; i < this.valueStack().size(); i++) {
            AppView.outputDebugMessage(
                    ((ArrayList<Integer>) this.valueStack()).elementAt(i).intValue() + " ");

        }
        AppView.outputLineDebugMessage("<Top>");
    }

    private CalculatorError executeBinaryOperator(char anOperator) {
        if (this.valueStack().size() < 2) {
            return CalculatorError.PostfixError_TooFewValues;
        }

        int operand1 = this.valueStack().pop().intValue();
        int operand2 = this.valueStack().pop().intValue();
        int calculated = 0;
        switch (anOperator) {
            case '^':
                calculated = (int) Math.pow((double) operand2, (double) operand1);
                break;
            case '*':
                calculated = operand2 * operand1;
                break;
            case '/':
                if (operand1 == 0) {
                    AppView.outputLineDebugMessage(anOperator + " : (DivideByZero) " + operand2 + " " + anOperator + " " + operand1);
                    return CalculatorError.PostfixError_DivideByZero;
                } else {
                    calculated = operand2 / operand1;
                }
                break;
            case '%':
                if (operand1 == 0) {
                    AppView.outputLineDebugMessage(anOperator + " : (DivideByZero) " + operand2 + " " + anOperator + " " + operand1);
                    return CalculatorError.PostfixError_DivideByZero;
                } else {
                    calculated = operand2 % operand1;
                }
                break;
            case '+':
                calculated = operand2 + operand1;
                break;
            case '-':
                calculated = operand2 - operand1;
                break;
            default:
                return CalculatorError.PostfixError_UnnknownOperator;
        }
        this.valueStack().push(Integer.valueOf(calculated));

        return CalculatorError.PostfixError_None;

    }


}
