package calculator.Model;

public class Calculator {

    /*
     * 계산기 클래스.
     */

    private final Adder adder = new Adder();
    private final NumberRepository numberRepository = new NumberRepository();
    private final Preprocessor preprocessor = new Preprocessor(numberRepository);


    public Long calculate(String calculateString) {
        preprocessor.preprocessing(calculateString);
        return adder.sumNumbers(numberRepository.getNumbers());

    }
    
}
