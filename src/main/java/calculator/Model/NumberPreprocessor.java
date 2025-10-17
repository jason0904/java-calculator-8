package calculator.Model;

public class NumberPreprocessor {

    /*
     * 숫자문자하나하나를 이어붙여서 숫자로 만드는 클래스.
     */

    private StringBuilder numberStringBuilder = new StringBuilder("");

    public void numberContinuousCharCalculate(char calculateChar) {
        numberStringBuilder.append(calculateChar);
    }

    public Long returnNumber() {
        return Long.parseLong(numberStringBuilder.toString());
    }
    
    public void resetTempNumber() {
        numberStringBuilder.delete(0, numberStringBuilder.length());
    }

    public boolean isNumberStringEmpty() {
        if(numberStringBuilder.length() == 0) return true;
        return false;
    }

    
}
