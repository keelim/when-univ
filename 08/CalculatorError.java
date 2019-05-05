public enum CalculatorError {//에러를 정의하는 enum 클래스
    InfixError_NoExpression,
    InfixError_TooLongExpression,
    InfixError_MissingLeftParen,
    InfixError_MissingRightParen,
    InfixError_UnknownOperator,
    InfixError_None,

    PostfixError_NoExpression,
    PostfixError_TooLongExpression,
    PostfixError_TooFewValues,
    PostfixError_TooManyValues,
    PostfixError_DivideByZero,
    PostfixError_UnknownOperator,
    PostfixError_None,

    Undefined

}
