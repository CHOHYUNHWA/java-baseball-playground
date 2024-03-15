package study.baseballGame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BaseballGameTest {

    BaseballGame baseballGame = new BaseballGame();


    @BeforeEach
    void setUp(){
        String answer = "243";
    }

    @ParameterizedTest
    @ValueSource(strings = {"123","456","789"})
    @DisplayName("ball Test")
    void ballTest(){
        String answer = "243";
    }

    @ParameterizedTest
    @ValueSource(strings = {"123","456","789"})
    @DisplayName("strike Test")
    void StrikeTest(){
    }

    @Test
    @DisplayName("생성된 정답 길이 검증")
    void generateAnswerLengthTest(){
        for (int i = 0; i < 100; i++) {
            Assertions.assertThat(baseballGame.makeAnswer().length()).isEqualTo(3);
        }
    }

    @Test
    @DisplayName("생성된 정답 중복 요소 존재 검증")
    void generateAnswerDuplicateTest(){
        for (int i = 0; i < 100; i++) {
            String answer = baseballGame.makeAnswer();

            char digit1 = answer.charAt(0);
            char digit2 = answer.charAt(1);
            char digit3 = answer.charAt(2);

            Assertions.assertThat(digit1).isNotEqualTo(digit2);
            Assertions.assertThat(digit2).isNotEqualTo(digit3);
            Assertions.assertThat(digit3).isNotEqualTo(digit1);

        }
    }
}
