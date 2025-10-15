package calculator.Model;

public class Calculator {

    private final Adder adder = new Adder();
    private final NumberRepository numberRepository = new NumberRepository();
    private final Preprocessor preprocessor = new Preprocessor(numberRepository);


    public Long calculate(String calculateString) {
        preprocessor.Preprocessing(calculateString);
        return adder.sumNumbers(numberRepository.getNumbers());

    }
    
}
