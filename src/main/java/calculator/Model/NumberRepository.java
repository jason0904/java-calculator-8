package calculator.Model;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class NumberRepository {

    /*
     * 숫자를 저장하는 클래스.
     */

    private final List<Long> numbers = new ArrayList<>();

    public void addNumber(Long number) {
        Objects.requireNonNull(number, "숫자 저장소에 null 숫자는 저장할 수 없습니다.");
        numbers.add(number);
    }

    public List<Long> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

}