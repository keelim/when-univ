public class CalculatorException extends Exception {
    private static final long serialVersionUID = 1L; //java exception version 관리

    private CalculatorError _error;

    public CalculatorError error() { //getter
        return _error;
    } //getter

    public void setEeror(CalculatorError _error) { //setter
        this._error = _error;
    } //setter

    public CalculatorException() { //constructor
        this.setEeror(CalculatorError.Undefined);
    } //constructor

    public CalculatorException(CalculatorError givenError) { //constructor
        this.setEeror(givenError);

    }

}
