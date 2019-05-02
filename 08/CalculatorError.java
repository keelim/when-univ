public enum CalculatorError {
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
    PostfixError_UnnknownOperator,
    PostfixError_None,

    Undefined

}
