package onboarding;

import java.util.List;

class Problem1 {
    public static int POBI_WIN = 1;
    public static int CRONG_WIN = 2;
    public static int DRAW = 0;
    public static int EXCEPT = -1;


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 1. 예외 확인하기
        if (isInvalid(pobi) || isInvalid(crong))
            return EXCEPT;

        // 2. pobi와 crong의 최종 점수 구하기
        int pobiScore = getFinalScore(pobi);
        int crongScore = getFinalScore(crong);

        // 3. pobi와 crong의 최종 승자 정하기
        if (pobiScore == crongScore)
            return DRAW;
        else if (pobiScore > crongScore)
            return POBI_WIN;
        else
            return CRONG_WIN;
    }


    /**
     * << 예외 처리하기 >>
     * 1. 리스트의 크기는 2
     * 2. 1 ~ 400 페이지 (첫번째, 마지막 페이지는 안함)
     * 3. 왼쪽페이지와 오른쪽페이지는 1페이지 차이
     * 4. 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수
     */
    public static boolean isInvalid(List<Integer> player) {
        if (player.size() != 2)
            return true;
        if (player.get(0) <= 1 || player.get(1) >= 400)
            return true;
        if (player.get(1) - player.get(0) != 1)
            return true;
        if (player.get(0) % 2 == 0 || player.get(1) % 2 != 0)
            return true;

        return false;
    }


    /**
     * << player의 최종 점수 구하기 >></>
     * -- 왼쪽 페이지 점수 vs 오른쪽 페이지 점수
     * -- 각 자리수 더하기 vs 각 자리수 곱하기
     */
    public static int getFinalScore(List<Integer> player) {
        return Math.max(getBiggerScore(player.get(0)), getBiggerScore(player.get(1)));
    }
    public static int getBiggerScore(int page) {
        String pageStr = String.valueOf(page);
        return Math.max(addNumber(pageStr), multiplyNumber(pageStr));
    }
    public static int addNumber(String page) {
        int num = 0;
        for (int i = 0; i < page.length(); i++) {
            num += Integer.parseInt(String.valueOf(page.charAt(i)));
        }
        return num;
    }
    public static int multiplyNumber(String page) {
        int num = 1;
        for (int i = 0; i < page.length(); i++) {
            num *= Integer.parseInt(String.valueOf(page.charAt(i)));
        }
        return num;
    }


} // problem 1 class