package calculator.Model;

public class NumberPreprocessor {

    private StringBuilder numberStringBuilder = new StringBuilder("");

    public void numberContinuousCharCalculate(char calculateChar) {
        numberStringBuilder.append(calculateChar);
    }

    public Long returnNumber() {
        return Long.parseLong(numberStringBuilder);
    }
    
    public void resetTempNumber() {
        numberStringBuilder.delete(0, numberStringBuilder.length());
    }

    
}
