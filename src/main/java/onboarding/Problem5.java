package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> coins = new ArrayList<>();

    public static List<Integer> solution(int money) {
        List<Integer> coins = List.of(50_000,10_000,5_000,1_000,500,100,50,10,1);

        List<Integer> ans = new ArrayList<>();
        for (Integer coin : coins) {
            ans.add(Math.floorDiv(money, coin));
            money -= coin * (Math.floorDiv(money, coin));
        }
        return ans;
    }


} // class problem5