package calculator.Model;

public class CustomOperatorPreprocessor {

    /*
     * 커스텀 연산자 모드인지 여부 판단, 커스터 오퍼레이터 저장.
     */

    private static CustomOperatorPreprocessor customOperatorProcessorInstance;
    private char customOperator;
    private boolean checkCustomOperatorFlag = false;

    public static CustomOperatorPreprocessor getInstance() {
        if (customOperatorProcessorInstance == null) customOperatorProcessorInstance = new CustomOperatorPreprocessor();
        return customOperatorProcessorInstance;
    }

    public boolean getCheckCustomOperatorFlag() {
        return checkCustomOperatorFlag;
    }

    public void setCustomOperatorFlag(boolean checkCustomOperatorFlag) {
        this.checkCustomOperatorFlag = checkCustomOperatorFlag;
    }


    public char getCustomOperator() {
        return customOperator;
    }

    public boolean checkCustomOperatorMode(String calculateString) {
        if(calculateString.substring(0, 2).equals("//") && calculateString.substring(3,6).equals("\\n")) {
            return true;
        }
        return false;
    }

    public void setCustomOperator(char customOperator) throws IllegalArgumentException {
        
        if (customOperator - '0' >= 0 && customOperator - '0' <= 9) throw new IllegalArgumentException("커스텀 구분자가 숫자입니다.");

        if (customOperator == ':' || customOperator == ',') throw new IllegalArgumentException("커스텀 구분자가 기본 구분자입니다.");

        this.customOperator = customOperator;
    }
    

}
