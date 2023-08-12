package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String words) {
        return changeWord(words);
    }

    private static HashMap<Character,Character> makeAlphapetMap() {
        String abc = "abcdefghijklmnopqrstuvwxyz";
        HashMap<Character, Character> dic = new HashMap<>();

        for (int i = 0; i < abc.length(); i++) {
            char key = abc.charAt(i);
            char value = abc.charAt(abc.length()-1-i);
            dic.put(key, value);
        }
        return dic;
    }


    private static String changeWord(String words) {
        StringBuilder sb_words = new StringBuilder();
        HashMap<Character,Character> alphabetDic = makeAlphapetMap();

        for (char word : words.toCharArray()) {
            if (Character.isLetter(word)) {
                char i = Character.toLowerCase(word);
                if (Character.isUpperCase(word))
                    sb_words.append(Character.toUpperCase(alphabetDic.get(i)));
                else
                    sb_words.append(alphabetDic.get(i));
            } else if (word == ' ') {
                sb_words.append(' ');
            }
        }
        return sb_words.toString();
    }


} // class problem4