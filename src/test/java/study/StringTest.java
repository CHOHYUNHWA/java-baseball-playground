package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void divideOneDotTwo() {
        String[] actualArray = "1,2".split(",");
        assertThat(actualArray).contains("1", "2");
        assertThat(actualArray).containsExactly("1", "2");
    }

    @Test
    void divideOnlyOne() {
        String[] actualArray = "1".split(",");
        assertThat(actualArray).contains("1");
        assertThat(actualArray).containsExactly("1");
    }

    @Test
    void divideOneDotTwoInParentheses() {
        String beforeString = "(1,2)";
        String actual = beforeString.substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열의 범위를 벗어났을 때 에러 테스트")
    void charAtTest(){
        String testString = "abc";
        assertThatThrownBy(() -> {
            testString.charAt(testString.length());
        })
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range")
                .hasMessageContaining(String.valueOf(testString.length()));


        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    testString.charAt(testString.length());
                }).withMessageMatching("String index out of range: \\d");
    }
}
