package study.baseballGame;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BaseballGame {

    public void startGame(){
        String answer = makeAnswer();
        System.out.println(answer);
        boolean endFlag = true;

        Scanner sc = new Scanner(System.in);
        while (endFlag) {
            System.out.print("숫자를 입력해 주세요 : ");
            String input = sc.next();
            String result = verifyInput(input, answer);
            System.out.println(result);
            endFlag = exitBaseBallGame(result);
        }
    }

    public String verifyInput(String input, String answer) {
        int strike = checkStrike(input, answer);
        int ball = checkBall(input, answer);

        if (strike == 0 && ball == 0) {
            answer = "낫싱";
        }

        if (strike == 0 && ball != 0) {
            answer = ball + "볼";
        }

        if (strike != 0 && ball == 0) {
            answer = strike + "스트라이크";
        }

        if (strike != 0 && ball != 0) {
            answer = ball + "볼" + " " + strike + "스트라이크";
        }
        return answer;
    }

    public int checkBall(String input, String answer) {
        int count = 0;
        if (answer.contains(String.valueOf(input.charAt(0))) && input.charAt(0) != answer.charAt(0)) {
            count++;
        }
        if (answer.contains(String.valueOf(input.charAt(1))) && input.charAt(1) != answer.charAt(1)) {
            count++;
        }
        if (answer.contains(String.valueOf(input.charAt(2))) && input.charAt(2) != answer.charAt(2)) {
            count++;
        }
        return count;
    }

    public int checkStrike(String input, String answer) {
        int count = 0;
        if (input.charAt(0) == answer.charAt(0)) {
            count++;
        }
        if (input.charAt(1) == answer.charAt(1)) {
            count++;
        }
        if (input.charAt(2) == answer.charAt(2)) {
            count++;
        }
        return count;
    }

    public String makeAnswer(){
        Set<Integer> set = new HashSet<>();
        String result;
        boolean flag = true;
        while (flag) {
            set.add((int) (Math.random() * 9) + 1);
            flag = checkAnswerLength(set);
        }
        result = set.stream().map(String::valueOf).reduce("", (s1, s2) -> s1 + s2);
        return result;
    }

    public boolean checkAnswerLength(Set<Integer> set){
        return set.size() != 3;
    }

    public boolean exitBaseBallGame(String result) {
        if (result.equals("3스트라이크")) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }
        return true;
    }

    public boolean checkReGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        return !input.equals("2");
    }
}
