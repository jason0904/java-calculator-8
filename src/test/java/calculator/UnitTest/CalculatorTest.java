package calculator.UnitTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import calculator.Calculator;

import java.util.List;
import java.util.ArrayList;

public class CalculatorTest {



    @Test
    @DisplayName("오버플로우 오류 반환 테스트")
    public void overflowTest() {

        Calculator calculator = new Calculator();
        
        List<Long> testList = new ArrayList<>();

        testList.add(Long.MAX_VALUE);
        testList.add(Long.valueOf(1));

        assertThrows(ArithmeticException.class, () -> {calculator.sumNumbers(testList);});
    }
    
    @Test
    @DisplayName("정상적인 합산 테스트")
    public void normalSumTest() {
        Calculator calculator = new Calculator();
        
        List<Long> testList = new ArrayList<>();

        testList.add(Long.valueOf(1));
        testList.add(Long.valueOf(2));
        testList.add(Long.valueOf(3));

        assertEquals(6, calculator.sumNumbers(testList));
    }

}
