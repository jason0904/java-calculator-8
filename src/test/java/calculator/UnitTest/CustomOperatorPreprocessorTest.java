package calculator.UnitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculator.Model.CustomOperatorPreprocessor;

public class CustomOperatorPreprocessorTest {


    @Test
    @DisplayName("커스텀 구분자 인식 테스트")
    public void customDelimiterTest() {
        CustomOperatorPreprocessor customOperatorPreprocessor = new CustomOperatorPreprocessor();
        assertEquals(customOperatorPreprocessor.checkCustomOperatorMode("//;\\n1;2"), true);
    }

    @Test
    @DisplayName("숫자 커스텀 구분자 테스트")
    public void numberCustomDelimiterTest() {
        CustomOperatorPreprocessor customOperatorPreprocessor = new CustomOperatorPreprocessor();
        assertThrows(IllegalArgumentException.class, () -> {customOperatorPreprocessor.setCustomOperator('1');});
    }

    @Test
    @DisplayName("기본 구분자 커스텀 구분자 테스트")
    public void defaultCustomDelimiterTest() {
        CustomOperatorPreprocessor customOperatorPreprocessor = new CustomOperatorPreprocessor();
        assertThrows(IllegalArgumentException.class, () -> {customOperatorPreprocessor.setCustomOperator(',');});
        assertThrows(IllegalArgumentException.class, () -> {customOperatorPreprocessor.setCustomOperator(':');});
    }

}
