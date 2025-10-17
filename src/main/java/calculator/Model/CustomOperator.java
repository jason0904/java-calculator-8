package calculator.Model;

public class CustomOperator {
    /*
     * 커스텀 연산자 타입 포장을 위한 클래스.
     */

    private final char customOperator;

    public CustomOperator(char customOperator) throws IllegalArgumentException {
        if (customOperator - '0' >= 0 && customOperator - '0' <= 9) throw new IllegalArgumentException("커스텀 구분자가 숫자입니다.");
        if (customOperator == ':' || customOperator == ',') throw new IllegalArgumentException("커스텀 구분자가 기본 구분자입니다.");
        this.customOperator = customOperator;
    }

    public char getCustomOperator() {
        return customOperator;
    }
}