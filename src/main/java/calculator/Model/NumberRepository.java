package calculator.Model;

import java.util.List;

public class NumberRepository {

    private List<Long> numbers = new ArrayList<>();

    public void addNumber(Long number) {
        numbers.add(number);
    }

    public List<Long> getNumbers() {
        return numbers;
    }

}