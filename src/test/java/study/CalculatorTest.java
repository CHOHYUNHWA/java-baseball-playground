package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    public static int addtion(int a, int b) {
        return a + b;
    }

    public static int subtraction(int a, int b) {
        return a - b;
    }

    public static int division(int a, int b) {
        return a / b;
    }

    public static int multiplication(int a, int b) {
        return a * b;
    }

    public static int calculate(String a, String b, String command){
        int parsedIntA = Integer.parseInt(a);
        int parsedIntB = Integer.parseInt(b);

        if (command.equals("+")) {
            return addtion(parsedIntA, parsedIntB);
        }
        if (command.equals("-")) {
            return subtraction(parsedIntA, parsedIntB);
        }
        if (command.equals("*")) {
            return multiplication(parsedIntA, parsedIntB);
        }
        if (command.equals("/")) {
            return division(parsedIntA, parsedIntB);
        }
        return 0;
    }

    @Test
    @DisplayName("2 + 3 * 4 / 2 = 10")
    public void calculatorTest(){
        String value = "2 + 3 * 4 / 2";
        String[] values = value.split(" ");
        Integer result = 0;
        for (int i = 0; i < values.length ; i+=2) {
            if(i == 0 ){
                result = Integer.parseInt(values[i]);
                continue;
            }
            result = calculate(result.toString(), values[i], values[i - 1]);
        }
        Assertions.assertThat(result).isEqualTo(10);
    }
}
