package calculator.UnitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculator.Model.CustomOperatorPreprocessor;

public class CustomOperatorPreprocessorTest {


    @Test
    @DisplayName("커스텀 구분자 인식 테스트")
    public void customDelimiterTest() {
        CustomOperatorPreprocessor customOperatorPreprocessor = new CustomOperatorPreprocessor();
        customOperatorPreprocessor.checkCustomOperatorMode("//;\\n1;2");
        assertEquals(customOperatorPreprocessor.getCheckCustomOperatorFlag(), true);
        assertEquals(customOperatorPreprocessor.getCustomOperator(), ';');
    }


    
}
