public class AppController {
    private static final char END_OF_CALCULATION = '!';
    private static final boolean DEBUG_MODE = true;

    private Calculator _calculator;

    public Calculator calculator() {
        return _calculator;
    } //getter

    public void setCalculator(Calculator newCalculator) {
        this._calculator = newCalculator;
    } //setter

    public AppController() { //constructor
        this.setCalculator(new Calculator());
        AppView.setDebugMode(AppController.DEBUG_MODE);
    }

    private String inputExpression() { //계산 수식 입력 메시지
        AppView.outputLine("");
        AppView.output("?계산할 수식을 입력하시오 (종료하려면 " +
                END_OF_CALCULATION + " 를 입력하시오): ");
        return AppView.inputLine(); // 메시지 입력
    }

    private void showCalculatorErrorMessage(CalculatorError anError) { //에러 핸들링
        switch (anError) { //파라미터의 값에 따라 오류 메시지가 달라진다.
            case InfixError_NoExpression:
                AppView.outputLine("[오류] 중위 계산식이 주어지지 않았습니다 ");
                break;
            case InfixError_TooLongExpression:
                AppView.outputLine("[오류] 중위 계산식이 너무 길어 처리할 수 없습니다.  ");
                break;
            case InfixError_MissingLeftParen:
                AppView.outputLine("[오류] 왼쪽 괄호가 빠졌습니다.  ");
                break;
            case InfixError_MissingRightParen:
                AppView.outputLine("[오류] 오른쪽 괄호가 빠졌습니다.  ");
                break;
            case InfixError_UnknownOperator:
                AppView.outputLine("[오류] 중위 계산식에 알 수 없는 연산자가 있습니다.  ");
                break;
            case PostfixError_NoExpression:
                AppView.outputLine("[오류] 후위 계산식이 주어지지 않았습니다.  ");
                break;
            case PostfixError_TooLongExpression:
                AppView.outputLine("[오류] 후위 계산식이 너무 길어 처리할 수 없습니다.  ");
                break;
            case PostfixError_TooFewValues:
                AppView.outputLine("[오류] 연산자에 비해 연산값의 수가 적습니다.   ");
                break;
            case PostfixError_TooManyValues:
                AppView.outputLine("[오류] 연산자에 비해 연산값의 수가 많습니다.   ");
                break;
            case PostfixError_DivideByZero:
                AppView.outputLine("[오류] 나눗셈의 분모가 0 입니다. ");
                break;
            case PostfixError_UnknownOperator:
                AppView.outputLine("[오류] 후위 계산식에 알 수 없는 연산자가 있습니다.");
                break;
            default:
                break;

        }
    }

    public void run() { //실행

        AppView.outputLine("<<< 계산기 프로그램을 시작합니다. >>>");
        String infixExpression = this.inputExpression(); //수식 입력
        while (infixExpression.charAt(0) != AppController.END_OF_CALCULATION) {
            try {
                int result = this.calculator().evaluate(infixExpression); //계산
                AppView.outputLine("> 계산값: " + result); //계산을 하여 값을 출력
            } catch (CalculatorException exception) {
                this.showCalculatorErrorMessage(exception.error()); //에러 값을 확인
            }
            infixExpression = this.inputExpression(); //재입력을 받는다.

        }

        AppView.outputLine("");
        AppView.outputLine("<<< 계산기 프로그램을 종료합니다. >>>");

    }
}
