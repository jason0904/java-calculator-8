package calculator.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;

public class CalculatorIO {

    /*
     * 계산기의 Input, Output을 담당.
     */

    private static final String INPUT_PROMPT = "덧셈할 문자열을 입력해 주세요.";
    private static final String OUTPUT_FORMAT = "결과 : %d%n";

    public String readInput() {
        System.out.println(INPUT_PROMPT);
        String inputString = Console.readLine();
        return inputString;
    }

    public void printOutput(Long result) {
        System.out.printf(OUTPUT_FORMAT, result);
    }

}