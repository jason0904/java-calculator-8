package calculator.Model;

public class NumberPreprocessor {

    /*
     * 숫자문자하나하나를 이어붙여서 숫자로 만드는 클래스.
     */

    private final StringBuilder numberStringBuilder = new StringBuilder("");

    public void numberContinuousCharCalculate(char calculateChar) {
        numberStringBuilder.append(calculateChar);
    }

    public Long returnNumber() {
        return Long.parseLong(numberStringBuilder.toString());
    }
    
    public void resetTempNumber() {
        numberStringBuilder.setLength(0);
    }

    public boolean isNumberStringEmpty() {
        return numberStringBuilder.length() == 0;
    }

    
}
