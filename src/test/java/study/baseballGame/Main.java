package study.baseballGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        boolean flag = true;
        while (flag) {
            baseballGame.startGame();
            flag = baseballGame.checkReGame();
        }
    }
}
