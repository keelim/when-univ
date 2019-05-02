public class CalculatorException extends Exception {
    private static final long serialVersionUID = 1L;

    private CalculatorError _error;

    public CalculatorError error() { //getter
        return _error;
    }

    public void setEeror(CalculatorError _error) { //setter
        this._error = _error;
    }

    public CalculatorException() {
        this.setEeror(CalculatorError.Undefined);
    }

    public CalculatorException(CalculatorError givenError) {
        this.setEeror(givenError);

    }

}
