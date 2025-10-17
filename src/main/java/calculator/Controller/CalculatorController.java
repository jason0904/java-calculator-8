package calculator.Controller;

import calculator.Model.Calculator;
import calculator.View.CalculatorIO;

public class CalculatorController {

    /*
     * 계산기 컨트롤러 클래스.
     */

    private Calculator calculator = new Calculator();
    private CalculatorIO calculatorIO = new CalculatorIO();

    public void run() {
        String input = calculatorIO.Input();
        Long result = calculator.calculate(input);
        calculatorIO.Output(result);
    }
}