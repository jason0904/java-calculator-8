package calculator.Model;

public class CustomOperatorPreprocessor {

    /*
     * 커스텀 연산자 모드인지 여부 판단, 커스터 오퍼레이터 저장.
     */

    private CustomOperator customOperator;
    private boolean checkCustomOperatorFlag = false;

    public boolean getCheckCustomOperatorFlag() {
        return checkCustomOperatorFlag;
    }

    public void setCustomOperatorFlag(boolean checkCustomOperatorFlag) {
        this.checkCustomOperatorFlag = checkCustomOperatorFlag;
    }


    public char getCustomOperator() {
        return customOperator.getCustomOperator();
    }

    public boolean checkCustomOperatorMode(String calculateString) {
        if(calculateString.startsWith("//") && calculateString.substring(3,5).equals("\\n")) {
            return true;
        }
        return false;
    }

    public void setCustomOperator(char customOperator) { 
              
        this.customOperator = new CustomOperator(customOperator);
    }
    

}


