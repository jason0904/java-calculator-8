package calculator.Model;

import calculator.Util.Util;

public class Preprocessor {

    /*
     * 문자를 읽고 숫자와 연산자로 분리하는 클래스.
     */
    

    private Character LastChar = null;
    private final NumberPreprocessor numberPreprocessor = new NumberPreprocessor();
    private final CustomOperatorPreprocessor customOperatorProcessor = new CustomOperatorPreprocessor();
    private final NumberRepository numberRepository;
    private final OperatorPreprocessor operatorPreprocessor;

    public Preprocessor(NumberRepository numberRepository) {
        this.numberRepository = numberRepository;
        this.operatorPreprocessor = new OperatorPreprocessor(customOperatorProcessor);
    }

    

    public boolean checkStringEmpty(String calculateString) {
        if(calculateString.length() == 0) return true;
        return false;
    }

    public boolean checkCharBlank(char calculateChar) {
        if(calculateChar == ' ') return true;
        return false;
    }

    public boolean checkCharIsLast(String calculateString) {
        if(calculateString.length() == 1) return true;
        return false;
    }

    public void Preprocessing(String calculateString) throws IllegalArgumentException {

        StringBuilder calculateStringBuilder = new StringBuilder(calculateString);

        if(checkStringEmpty(calculateString)) throw new IllegalArgumentException("문자열이 비어있습니다.");

        while(!calculateStringBuilder.isEmpty()) {
            //커스텀 문자열 인식자 들어오면 체크 후 통과;
            if(customOperatorProcessor.checkCustomOperatorMode(calculateStringBuilder.toString())) {
                customOperatorProcessor.setCustomOperatorFlag(true);
                customOperatorProcessor.setCustomOperator(calculateStringBuilder.charAt(2));
                //마지막 문자 하나를 남겨두는 이유는 마지막에 하나를 더 삭제하기 때문.
                calculateStringBuilder.delete(0,4);
            }
            //연산자이면 그냥 놔두기.
            else if(operatorPreprocessor.isCharOperator(calculateStringBuilder.charAt(0))) {
                //연산자가 맨앞에 들어와도 오류.
                if(LastChar == null) throw new IllegalArgumentException("첫번째 문자가 연산자입니다.");

                //연산자가 마지막에 들어오면 오류.
                if(checkCharIsLast(calculateStringBuilder.toString())) throw new IllegalArgumentException("마지막문자가 연산자입니다.");

                //연산자가 두번연속으로 쓰여도 요류.
                if(operatorPreprocessor.isCharOperator(LastChar)) throw new IllegalArgumentException("연산자가 두번 연속 쓰였습니다.");
                
            }
            //숫자이면 숫자계산
            else if(Util.isCharInteger(calculateStringBuilder.charAt(0))) {
                //끝나면 전 숫자 반환.
                if(LastChar != null && LastChar != 'n' && !Util.isCharInteger(LastChar)) {
                    if(!numberPreprocessor.isNumberStringEmpty())numberRepository.addNumber(numberPreprocessor.returnNumber());
                    numberPreprocessor.resetTempNumber();
                }
                numberPreprocessor.numberContinuousCharCalculate(calculateStringBuilder.charAt(0));
            }
            else if(checkCharBlank(calculateStringBuilder.charAt(0))) {}

            //나머지는 문제있는 거니 오류 출력
            else throw new IllegalArgumentException("잘못된 문자를 입력하셨습니다.");
            
            LastChar = calculateStringBuilder.charAt(0);
            calculateStringBuilder.deleteCharAt(0);
        }
        
        numberRepository.addNumber(numberPreprocessor.returnNumber());
    }

    

}
