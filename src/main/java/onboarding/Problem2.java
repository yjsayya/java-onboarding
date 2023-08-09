package onboarding;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        while (hasDuplicateCharacters(cryptogram)) {
            cryptogram = removeDuplicatedLetter(cryptogram);
        }
        return cryptogram;
    }

    /**
     * 중복되는 알파벳 있는지 검사
     */
    public static boolean hasDuplicateCharacters(String input) {
        Set<Character> characterSet = new HashSet<>();
        for (char c : input.toCharArray()) {
            characterSet.add(c);
        }
        return input.length() != characterSet.size();
    }

    /**
     * 중복되는 알파벳 제거
     */
    public static String removeDuplicatedLetter(String cryptogram) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < cryptogram.length(); i++) {
            String ch = String.valueOf(cryptogram.charAt(i));
            if (!stack.isEmpty() && stack.peek().equals(ch))
                stack.pop();
            else
                stack.add(ch);
        }
        return String.join("",stack);
    }
}
