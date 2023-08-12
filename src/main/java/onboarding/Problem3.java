package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return playGame(number);
    }

    /**
     * 게임 시작
     */
    public static int playGame(int number) {
        int cnt = 0;
        for (int i = 1; i <= number; i++) {
            cnt += count369(number);
        }
        return cnt;
    }

    /**
     * 해당 숫자의 들어있는 3,6,9의 개수 구하기
     */
    public static int count369(int number) {
        String numStr = String.valueOf(number);
        int cnt = 0;
        for (char i : numStr.toCharArray()) {
            if (i == '3' || i == '6' || i == '9')
                cnt++;
        }
        return cnt;
    }

}