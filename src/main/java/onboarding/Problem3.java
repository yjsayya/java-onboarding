package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int cnt = 0;
        for (int i = 1; i <= number; i++) {
            cnt += count(Integer.toString(i));
        }
        return cnt;
    }

    public static int count(String num) {
        int cnt = 0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '3' || num.charAt(i) == '6' || num.charAt(i) == '9')
                cnt++;
        }
        return cnt;
    }


}