package calculator.UnitTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculator.Model.NumberPreprocessor;

public class NumberPreprocessorTest {

    @Test
    @DisplayName("입력값 Long 범위 벗어나는 테스트")
    public void outOfLongRangeTest() {
        NumberPreprocessor numberPreprocessor = new NumberPreprocessor();
        assertThrows(NumberFormatException.class, () -> {
            for(char c : "9223372036854775808".toCharArray()) {
                numberPreprocessor.numberContinuousCharCalculate(c);
            }
            numberPreprocessor.returnNumber();
        });
    }
    
}
