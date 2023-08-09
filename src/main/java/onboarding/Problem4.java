package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String words) {
        String abc = "abcdefghijklmnopqrstuvwxyz";
        Map<Character, Character> dic = new HashMap<>();

        for (int i = 0; i < abc.length(); i++) {
            char key = abc.charAt(i);
            char value = abc.charAt(abc.length() - 1 - i);
            dic.put(key, value);
        }

        StringBuilder ans = new StringBuilder();
        for (char word : words.toCharArray()) {
            if (Character.isLetter(word)) {
                char lowerWord = Character.toLowerCase(word);
                if (Character.isUpperCase(word))
                    ans.append(Character.toUpperCase(dic.get(lowerWord)));
                else
                    ans.append(dic.get(lowerWord));
            } else {
                ans.append(word);
            }
        }
        return ans.toString();
    }


} // class problem4