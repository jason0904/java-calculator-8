package calculator.Model;

import java.util.List;

public class Adder {

    /*
     *  숫자를 더하는 클래스, 오버플로우 감지되면 ArithmaticException 반환.
     */

    public long sumNumbers(List<Long> numbers) {
        long sum = 0;
        for(long num : numbers) sum = Math.addExact(sum, num);
        
        return sum;
    }


    

}
