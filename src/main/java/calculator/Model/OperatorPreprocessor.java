package calculator.Model;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class OperatorPreprocessor {

    private final CustomOperatorProcessor customOperatorProcessor;
    private final List<Character> operatorList = new ArrayList<>(Arrays.asList(':',','));

    public OperatorPreprocessor(CustomOperatorProcessor customOperatorProcessor) {
        this.customOperatorProcessor = customOperatorProcessor;
    }
    
    public boolean isCharOperator(char calculateChar) {
        if(customOperatorProcessor.getCheckCustomOperatorFlag() && customOperatorProcessor.getCustomOperator() == calculateChar) return true;
        if(operatorList.contains(calculateChar)) return true;
        return false;
    }
    
}
