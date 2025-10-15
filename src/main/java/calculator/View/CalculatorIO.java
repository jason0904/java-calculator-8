package calculator.View;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorIO {

    /*
     * 계산기의 Input, Output을 담당.
     */

    private static final String Input_String = "덧셈할 문자열을 입력해 주세요.";
    private static final String Output_String = "결과 : %d";

    public String Input() {
        
        System.out.println(Input_String);
        String inputString = Console.readLine();

        return inputString;

    }

    public void Output(int result) {
        System.out.printf(Output_String, result);
    }

}