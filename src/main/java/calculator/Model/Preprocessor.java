package calculator.Model;

public class Preprocessor {

    /*
     * 문자를 읽고 숫자와 연산자로 분리하는 클래스.
     */
    

    private LastChar lastChar = null;
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

    public void preprocessing(String calculateString) throws IllegalArgumentException {
        if (checkStringEmpty(calculateString)) {
            throw new IllegalArgumentException("문자열이 비어있습니다.");
        }

        StringBuilder calculateStringBuilder = new StringBuilder(calculateString);

        while (!calculateStringBuilder.isEmpty()) {
            processNextToken(calculateStringBuilder);
        }

        numberRepository.addNumber(numberPreprocessor.returnNumber());
    }

    private void processNextToken(StringBuilder calculateStringBuilder) {
        if (customOperatorProcessor.checkCustomOperatorMode(calculateStringBuilder.toString())) {
            processCustomOperator(calculateStringBuilder);
            return;
        } 
        else if (operatorPreprocessor.isCharOperator(calculateStringBuilder.charAt(0))) {
            processOperator(calculateStringBuilder);
            return;
        } 
        else if (Character.isDigit(calculateStringBuilder.charAt(0))) {
            processNumber(calculateStringBuilder);
            return;
        } 
        else if (checkCharBlank(calculateStringBuilder.charAt(0))) {
            processBlank(calculateStringBuilder);
            return;
        } 
        throw new IllegalArgumentException("잘못된 문자를 입력하셨습니다.");
    }

    private void processCustomOperator(StringBuilder calculateStringBuilder) {
        customOperatorProcessor.setCustomOperatorFlag(true);
        customOperatorProcessor.setCustomOperator(calculateStringBuilder.charAt(2));
        lastChar = new LastChar(calculateStringBuilder.charAt(5));
        calculateStringBuilder.delete(0, 5);
    }

    private void processOperator(StringBuilder calculateStringBuilder) {
        validateOperatorPosition(calculateStringBuilder.toString());
        lastChar = new LastChar(calculateStringBuilder.charAt(0));
        calculateStringBuilder.deleteCharAt(0);
    }

    private void validateOperatorPosition(String calculateString) {
        if (lastChar == null) {
            throw new IllegalArgumentException("첫번째 문자가 연산자입니다.");
        }
        if (checkCharIsLast(calculateString)) {
            throw new IllegalArgumentException("마지막문자가 연산자입니다.");
        }
        if (operatorPreprocessor.isCharOperator(lastChar.getLastChar())) {
            throw new IllegalArgumentException("연산자가 두번 연속 쓰였습니다.");
        }
    }

    private void processNumber(StringBuilder calculateStringBuilder) {
        if (lastChar != null && !Character.isDigit(lastChar.getLastChar())) {
            processNumberStringToNumber();
        }
        char currentChar = calculateStringBuilder.charAt(0);
        numberPreprocessor.numberContinuousCharCalculate(currentChar);
        lastChar = new LastChar(currentChar);
        calculateStringBuilder.deleteCharAt(0);
    }

    private void processNumberStringToNumber() {
        if (!numberPreprocessor.isNumberStringEmpty()) {
            numberRepository.addNumber(numberPreprocessor.returnNumber());
        }
        numberPreprocessor.resetTempNumber();
    }

    private void processBlank(StringBuilder calculateStringBuilder) {
        lastChar = new LastChar(calculateStringBuilder.charAt(0));
        calculateStringBuilder.deleteCharAt(0);
    }



}
