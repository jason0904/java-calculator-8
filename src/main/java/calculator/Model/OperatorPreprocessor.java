package calculator.Model;

import java.util.Set;

public class OperatorPreprocessor {

    /*
     * 연산자인지 확인하는 클래스.
     */

    private final CustomOperatorPreprocessor customOperatorProcessor;
    private final Set<Character> operatorSet = Set.of(':', ',');

    public OperatorPreprocessor(CustomOperatorPreprocessor customOperatorProcessor) {
        this.customOperatorProcessor = customOperatorProcessor;
    }
    
    public boolean isCharOperator(char calculateChar) {
        if(customOperatorProcessor.getCheckCustomOperatorFlag() && customOperatorProcessor.getCustomOperator() == calculateChar) return true;
        if(operatorSet.contains(calculateChar)) return true;
        return false;
    }
    
}
