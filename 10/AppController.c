#pragma once
#include "AppController.h"

struct _AppController {
    char _expression[MAX_NUMBER_OF_TOKENS];
    Postfix *_postfix;
};

void AppController_run(AppController *_this) {
    Boolean expressionIsAvailable;
    PostfixError evaluationError;
    AppView_out_startingMessage();
    _this->_postfix = Postfix_new(MAX_NUMBER_OF_TOKENS);
    expressionIsAvailable = AppView_in_postfixExpression(_this->_expression);
    while (expressionIsAvailable) {
        Postfix_setExpression(_this->_postfix, _this->_expression);
        evaluationError = Postfix_evaluate(_this->_postfix);
        if (evaluationError == PostfixError_None) {
            AppView_out_evaluatedValue(Postfix_evaluatedValue(_this->_postfix));
        } else {
            AppView_out_postfixEvaluationErrorMessage(evaluationError);

        }
        expressionIsAvailable = AppView_in_postfixExpression(_this->_expression);
    }
    Postfix_delete(_this->_postfix);
    AppView_out_endingMessage();
}

