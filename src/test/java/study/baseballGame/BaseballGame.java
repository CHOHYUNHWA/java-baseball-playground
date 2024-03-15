package study.baseballGame;

import java.util.HashSet;
import java.util.Set;

public class BaseballGame {

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


}
