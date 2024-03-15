package study.caculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CalculatorTest {

    @Test
    @DisplayName("2 + 3 * 4 / 2")
    public void calculatorTest() {
        Calculator calculator = new Calculator();
        String value = "2 + 3 * 4 / 2";
        String[] values = value.split(" ");
        Integer result = 0;
        for (int i = 0; i < values.length; i += 2) {
            if (i == 0) {
                result = Integer.parseInt(values[i]);
                continue;
            }
            result = calculator.calculate(result.toString(), values[i], values[i - 1]);
        }
        Assertions.assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("addition")
    public void additionTest(){
        Calculator calculator = new Calculator();
        int actual = 5 + 2;
        int expect = calculator.addtion(5, 2);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    @DisplayName("subtraction")
    public void subtractionTest(){
        Calculator calculator = new Calculator();
        int actual = 5 - 2;
        int expect = calculator.subtraction(5, 2);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    @DisplayName("division")
    public void divisionTest(){
        Calculator calculator = new Calculator();
        int actual = 4 / 2;
        int expect = calculator.division(4, 2);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    @DisplayName("multiplication")
    public void multiplicationTest(){
        Calculator calculator = new Calculator();
        int actual = 5 * 2;
        int expect = calculator.multiplication(5, 2);
        assertThat(actual).isEqualTo(expect);
    }
}

