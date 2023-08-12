package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        String ans = "";
        return decode(cryptogram);
    }


    /**
     *
     */
    static String decode(String cryptogram) {
        StringBuilder code = new StringBuilder(cryptogram);
        int codeLength = 0;

        do {
            codeLength = code.length();
            code = deleteDuplicatedAlphabet(code);
        } while (code.length() != codeLength && code.length() != 0);

        return code.toString();
    }


    /**
     * 중복된 알파벳 제거
     */
    static StringBuilder deleteDuplicatedAlphabet(StringBuilder code) {
        StringBuilder result = new StringBuilder();
        boolean isDuplicated = false;

        code.append(" ");
        for (int i = 0; i < code.length()-1; i++) {
            if (code.charAt(i) == code.charAt(i+1)) {
                isDuplicated = true;
                continue;
            }
            if (isDuplicated) {
                isDuplicated = false;
                continue;
            }
            result.append(code.charAt(i));
        }
        return result;
    }

}