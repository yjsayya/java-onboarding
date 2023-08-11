package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> friendScore = new HashMap<>();

        // 1. dic 만들기
        Map<String, List<String>> dic = new HashMap<>();
        for (List<String> friend : friends) {
            String i = friend.get(0);
            String j = friend.get(1);

            if (dic.containsKey(i))
                dic.get(i).add(j);
            else
                dic.put(i, new ArrayList<>(Arrays.asList(j)));

            if (dic.containsKey(j))
                dic.get(j).add(i);
            else
                dic.put(j, new ArrayList<>(Arrays.asList(i)));
        }

        // 2. 함께 아는 친구의 수 - 구하기
        Set<String> userSet = new HashSet<>(dic.get(user));
        dic.remove(user);
        for (String i : dic.keySet()) {
            Set<String> intersection = new HashSet<>(dic.get(i));
            intersection.retainAll(userSet);

            friendScore.put(i, intersection.size() * 10);
        }

        // 3. 방문자 점수 - 구하기
        for (String visitor : visitors) {
            if (!friendScore.containsKey(visitor)) {
                int visitorCount = (int) visitors.stream().filter(s -> s.equals(visitor)).count();
                friendScore.put(visitor, visitorCount);
            }
        }

        // 4. 정리해서 답 내기
        List<String> ans = friendScore.entrySet().stream()
                .filter(entry -> entry.getValue() > 0) // Keep only entries with value > 0
                .sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder()) // Sort by value in descending order
                        .thenComparing(Map.Entry.comparingByKey(Comparator.naturalOrder()))) // Sort by key in natural order, if values are equal
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return ans;
    }

}