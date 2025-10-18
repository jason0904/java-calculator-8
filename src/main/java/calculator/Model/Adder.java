package calculator.Model;

import java.util.List;
import java.util.Objects;

public class Adder {

    /*
     *  숫자를 더하는 클래스, 오버플로우 감지되면 ArithmaticException 반환.
     */

    public long sumNumbers(List<Long> numbers) {
        Objects.requireNonNull(numbers);
        return numbers.stream()
                      .mapToLong(Long::longValue)
                      .reduce(0L, (a, b) -> Math.addExact(a, b));
    }

}
